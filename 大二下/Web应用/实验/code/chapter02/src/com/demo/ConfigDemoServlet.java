package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(name="ConfigDemoServlet",
		urlPatterns = {"/config-demo"}, 
		initParams = { 
			@WebInitParam(name = "email", value = "hacker@163.com"), 
			@WebInitParam(name = "telephone", value = "8899123")
		})
public class ConfigDemoServlet extends HttpServlet{
String servletName = null;
ServletConfig config = null;
String email = null;
String telephone = null;

public void init(ServletConfig config) {
this.config = config;
servletName = config.getServletName();
email = config.getInitParameter("email");
telephone = config.getInitParameter("telephone");
}
public void doGet(HttpServletRequest request, 
HttpServletResponse response)
                           throws ServletException,IOException{  
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
out.println("<html><body>");
out.println("<head><title>配置对象</title></head>");
out.println("Servlet名称："+servletName+"<br>");
out.println("Email地址："+email+"<br>");	
out.println("电话："+telephone);
out.println("</body></html>");
}
}

