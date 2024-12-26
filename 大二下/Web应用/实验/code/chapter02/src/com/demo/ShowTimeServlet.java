package com.demo;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="showTimeServlet",urlPatterns={"/show-time"})
public class ShowTimeServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, 
                          HttpServletResponse response)
                         throws ServletException, IOException{
      response.setContentType("text/html;charset=UTF-8");
      response.setHeader("Refresh","5");
      PrintWriter out = response.getWriter();
      LocalTime now = LocalTime.now();
      DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss");
      String t = now.format(format);
   
      out.println("<html>");
      out.println("<head><title>当前时间</title></head>");
      out.println("<body>");
      out.println("<p>每5秒钟刷新一次页面<p>");
      out.println("<p>现在的时间是："+t+"<p>");
      out.println("</body>");
      out.println("</html>");
   }  
}
