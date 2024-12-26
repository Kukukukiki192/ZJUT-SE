
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

@WebServlet("/parsejson.do")
@MultipartConfig
//(location="C:\\temp\\",fileSizeThreshold=1024)
public class ParseJsonServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part p = request.getPart("filename");
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		StringBuffer json=new StringBuffer(2*1024*1024);	
		String s="";
		while((s=br.readLine())!=null){
			json.append(s.trim());
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<title>学生成绩列表</title></head>");
		out.println("<script type=\"text/javascript\"> function test()");
		out.println("{document.getElementById(\"tableInfo\").value=document.getElementById(\"table\").innerHTML;}");
		out.println("</script>");
		out.println("<body><h3 align='center'>学生成绩列表</h3>");
		out.println("<form action=\"exportfile.do\"methd=\"post\">");
		out.println("<table align='center' border=1>");
		out.println("<tr align='center' bgcolor='#009999'><td>序号</td><td>学号</td><td>姓名</td><td>课程名</td><td>成绩</td></tr>");
		JSONArray objects=JSON.parseArray(json.toString());
		for(int i=0;i<objects.size();i++){
			JSONObject object=(JSONObject)objects.get(i);
			System.out.println(object.getString("stuid"));
			System.out.println(object.getString("name"));
			System.out.println(object.getString("courseName"));
			System.out.println(object.getString("score"));
			
			out.println("<tr align='center'>");
			out.println("<td>"+(i+1)+"</td>");
			out.println("<td>"+object.getString("stuid"));
			out.println("<td>"+object.getString("name"));
			out.println("<td>"+object.getString("courseName"));
			out.println("<td>"+object.getString("score"));
			out.println("</tr>");
		}				
		out.println("</table><br/>");
//		out.println("<a href='exportfile.do'>导出excel</a>");
		out.println("<h4 align='center'><input type='submit' name='excel' value='导出表格' onclick='test()'/>");
		out.println("<input type='hidden' id='tableInfo' name='tableInfo' value='\' />");
		out.println("</form></body></html>");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}
}
