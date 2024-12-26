package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SendCookie")
public class SendCookieServlet extends HttpServlet{
  public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
      throws IOException,ServletException{
      Cookie userCookie = new Cookie("username", "hacker"); 
      
      userCookie.setMaxAge(60*60*24*7);
      response.addCookie(userCookie);
      
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 out.println("<html><title>发送Cookie</title>");
		 out.println("<body><h3>已向浏览器发送一个Cookie。</h3></body>");
		 out.println("</html>");
	  } 
}

