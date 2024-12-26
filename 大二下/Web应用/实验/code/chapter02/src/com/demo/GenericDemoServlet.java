package com.demo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "genericServlet", urlPatterns = { "/generic-servlet" })
public class GenericDemoServlet extends GenericServlet{
	private static final long serialVersionUID = 1L;
	private transient ServletConfig servletConfig;
	@Override
	public void service(ServletRequest request,
	                    ServletResponse response) 
	               throws ServletException,IOException {
       servletConfig = getServletConfig();
	   String servletName = servletConfig.getServletName();
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.print("<!DOCTYPE html>"	+ "<html>"
	                 + "<body>Hello from " + servletName +"<br>"
	                 + "世界那么大，我想去看看。"
	                 + "</body></html>");
	}
}

