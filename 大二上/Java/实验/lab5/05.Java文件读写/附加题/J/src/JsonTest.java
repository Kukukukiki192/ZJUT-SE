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
		//������jsonȫ��д���ַ���line
		while(reader.ready()) {
			line=line+reader.readLine();
		}
		//ȡ���ַ�����ʽ��features�����ǰ������й��ҵ�һ��JSON���飩
		JSONObject jsonObject = JSON.parseObject(line);
		String features=jsonObject.getString("features");		
		//��ȡ�����ַ�����ʽ��featuresת����JSON����
		JSONArray jsonArray = JSON.parseArray(features);		
		//�õ�����ȥ����JSON����
		Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
        	//��ȡ��ǰ��������JSON����Ԫ�أ���һ��JSON object
            JSONObject jsonObjectTemp = (JSONObject) iterator.next();
            //ȡ����ǰJSON����Ԫ�ص�properties��
            String properties=jsonObjectTemp.getString("properties");
            //��propertiesת����JSON object
            JSONObject JSONproperties=JSON.parseObject(properties);
            System.out.println("country name: " + JSONproperties.getString("name"));
        }reader.close();
	}	
}
