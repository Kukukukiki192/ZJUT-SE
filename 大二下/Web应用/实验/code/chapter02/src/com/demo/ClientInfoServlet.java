package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/client-information")
public class ClientInfoServlet extends HttpServlet {
	    public void doGet(HttpServletRequest request,
HttpServletResponse response)
	                   	throws ServletException, IOException {
		   response.setContentType("text/html;charset=UTF-8");
		   PrintWriter out = response.getWriter();
		   out.println("<html><head>");
		   out.println("<title>客户端信息</title></head>");
		   out.println("<body>");
		   out.println("<p>客户端信息：</p>");
       out.println(request.getMethod()+" "
    	        +request.getRequestURI()+" "
    	        +request.getProtocol()+"<br>");
		   out.println("<p>客户主机名:" + request.getRemoteHost()+"</p>");
	        out.println("<p>客户IP地址:" + request.getRemoteAddr()+"</p>");
	        out.println("<p>端口号:" + request.getRemotePort()+"</p>");
		   out.println("</body></html>");
	}
}

