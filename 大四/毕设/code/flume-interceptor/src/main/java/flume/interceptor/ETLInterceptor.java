package flume.interceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/**
 * 采集日志到 Kafka 阶段拦截器
 * 作用：过滤格式不正确的非法数据(时间戳不合法 Json数据不完整)
 */
public class ETLInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    // source拉取一个数据
    @Override
    public Event intercept(Event event) {
        //取数据 后校验

        // 1 获取数据
        byte[] body = event.getBody();
        String log = new String(body, StandardCharsets.UTF_8);

        // 2 验证
        if (JSONUtils.isValidate(log)) {
            return event;
        } else {
            return null;
        }
    }

    // source拉取一批数据
    @Override
    public List<Event> intercept(List<Event> list) {
        Iterator<Event> iterator = list.iterator();
        while (iterator.hasNext()){
            Event next = iterator.next();
            if(intercept(next)==null){
                iterator.remove(); // 过滤掉脏数据
            }
        }
        return list;
    }

    @Override
    public void close() {

    }

    // 静态内部类
    public static class Builder implements Interceptor.Builder {

        @Override
        public Interceptor build() {
            return new ETLInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
