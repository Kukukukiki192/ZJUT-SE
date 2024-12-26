package flume.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**消费 Kafka 日志阶段拦截器
 * 作用：获取日志中的实际时间
 * 思路：拦截 json 日志,通过 fastjson 框架解析 json,获取实际时间 ts.
 *  将获取的 ts 时间写入拦截器 header 头,header 的 key 必须是 timestamp,
 *  因为 Flume 框架会根据这个key 的值识别为时间,写入到 HDFS
 */
public class TimeStampInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {
        Map<String, String> headers = event.getHeaders();
        String log = new String(event.getBody(),StandardCharsets.UTF_8);
        JSONObject jsonObject = JSONObject.parseObject(log);
        String ts = jsonObject.getString("ts");
        headers.put("timestamp", ts);
        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        for (Event event : list) {
            intercept(event);
        }
        return list;
    }

    @Override
    public void close() {

    }

    public static class Builder implements Interceptor.Builder {
        @Override
        public Interceptor build() {
            return new TimeStampInterceptor();
        }
        @Override
        public void configure(Context context) {
        }
    }
}
