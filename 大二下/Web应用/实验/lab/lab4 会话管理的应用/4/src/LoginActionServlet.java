

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

@WebServlet("/LoginActionServlet")
public class LoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String usertype = request.getParameter("usertype");
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Path = "D:/Web应用/4/WebContent/WEB-INF/user";	//写成user.txt找不到文件
        BufferedReader br=new BufferedReader(new FileReader(Path));
		String s;
		StringBuffer s1 = new StringBuffer();
		while((s=br.readLine())!=null) {
			s1.append(s);
		}br.close();
		String str = new String(s1);	
		String[] strArr = str.split("\\t");
		int flag=0; 
		String Name="";
		for(int i=0;i<strArr.length;i+=4) {
			if(username.equals(strArr[i])&&password.equals(strArr[i+1])) {flag=1; Name=strArr[i+2];}			
		}
		HttpSession session = request.getSession(true);
		if(flag==1) {
			UserBean user=new UserBean(username,password,Name,usertype);
			session.setAttribute("user", user);
//			if(usertype.equals("学生")) response.sendRedirect("student.jsp");//下拉框选项有value时,要用value值比较：usertype.equals("Stuent")
			if(usertype.equals("学生")) response.sendRedirect("studentOperation.jsp");
//			else response.sendRedirect("teacher.jsp");AllHomworkServlet
			else response.sendRedirect("AllHomworkServlet");
		}
		else response.sendRedirect("login.jsp");
		doGet(request, response);
	}
}
