

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;

@WebServlet("/AllHomworkServlet")//不能用homework.html
public class AllHomworkServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String Path = "D:/Web应用/4/WebContent/WEB-INF/homework.txt";	
        BufferedReader br=new BufferedReader(new FileReader(Path));
		String s;
		StringBuffer s1 = new StringBuffer();
		while((s=br.readLine())!=null) {
			s1.append(s);
		}br.close();
		String str = new String(s1);	
		String[] strArr = str.split("\\t");
		
		HttpSession session = request.getSession();
        UserBean c= (UserBean)session.getAttribute("user");
		response.setContentType("text/html;charset=utf-8");//必不可少
		PrintWriter out= response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>已上传作业</title></head>");
		out.println("<body><center><h4>已上传的作业</h4>");
		out.println("<table border='0'>");
	    out.println("<tr bgcolor=\"Tan\"><td>序号</td><td>学号</td><td>姓名</td><td>作业标题</td><td>上传时间</td><td>下载</td></tr>");
	    for(int i=0;i<strArr.length;i+=5) {
	    	int j=i%5;
	    	out.println("<tr bgcolor=\"LightBlue\"><td>"+j+"</td><td>"+strArr[i]+"</td><td>"+strArr[i+1]
	    		+"</td><td>"+strArr[i+2]+"</td><td>"+strArr[i+3]
	    		+"</td><td><a href='downloadHomework.do?studentid="+strArr[i]+"&filename="+strArr[i+4]+"'>下载</a></td></tr>");			
		}
	    out.println("</table></center>");
	    if(c.getType().equals("学生")) {
	    	out.println("<a href='studentOperation.jsp'>返回操作页面</a>");
	    }else { 
	    	out.println("<a href='login.jsp'>返回登录页面</a>");
	    }
	    out.println("</body></html>");
	}
}
