import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
	public static void main(String[] args) throws IOException {		
		String file= "world.json";
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(new FileInputStream(file), "gb2312"));
		String line = "";
		//将所有json全部写入字符串line
		while(reader.ready()) {
			line=line+reader.readLine();
		}
		//取出字符串形式的features（这是包含所有国家的一个JSON数组）
		JSONObject jsonObject = JSON.parseObject(line);
		String features=jsonObject.getString("features");		
		//将取出的字符串形式的features转化成JSON数组
		JSONArray jsonArray = JSON.parseArray(features);		
		//用迭代器去遍历JSON数组
		Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
        	//获取当前遍历到的JSON数组元素，是一个JSON object
            JSONObject jsonObjectTemp = (JSONObject) iterator.next();
            //取出当前JSON数组元素的properties串
            String properties=jsonObjectTemp.getString("properties");
            //将properties转化成JSON object
            JSONObject JSONproperties=JSON.parseObject(properties);
            System.out.println("country name: " + JSONproperties.getString("name"));
        }reader.close();
	}	
}
