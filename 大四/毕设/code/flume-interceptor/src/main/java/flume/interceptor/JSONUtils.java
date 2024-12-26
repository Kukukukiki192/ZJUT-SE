package flume.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

public class JSONUtils {
    // 测试
//    public static void main(String[] args) {
//        System.out.println(isValidate("222")); //判断{}要用startsWith endsWith
//        System.out.println(isValidate("{\"age\":18}"));
//    }

    // 验证数据是否json
    public static boolean isValidate(String log){
        try {
            JSON.parse(log);
            return true;
        }catch (JSONException e){
            return false;
        }
    }
}
