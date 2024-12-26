package com.demo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "helloServlet", urlPatterns = { "/helloServlet.do" })
public class HelloServlet extends HttpServlet {
	private static final Log logger = 
			 LogFactory.getLog(HelloServlet.class);
	     private static final long serialVersionUID = 1L;
   public void doGet(HttpServletRequest request, 
                     HttpServletResponse response) 
               throws ServletException, IOException {
            logger.info("日志信息！！！");
            getServletContext().log("Log方法的输出");
	        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
		    out.println("<html>");
		    out.println("<body><title>Hello Servlet</title>");
		    out.println("<h3 style='color:#00f'>Hello,World!</h3>");
		    out.println("今天的日期是:" + LocalDate.now() + "<br>");
		    out.println("现在的时间是:" + LocalTime.now() + "<br>");
		    out.println("日志类名:" + logger.getClass().getName());
		    out.println("</body>");
		    out.println("</html>");
	     }
}

