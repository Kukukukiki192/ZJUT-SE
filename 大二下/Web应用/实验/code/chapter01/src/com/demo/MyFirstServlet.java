package com.demo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "myFirstServlet", urlPatterns = { "/my-first-servlet" })
public class MyFirstServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response)
                        throws ServletException, IOException {
       // 设置响应的内容类型
       response.setContentType("text/html;charset=UTF-8");
       // 获取一个打印输出流对象
       PrintWriter out = response.getWriter();
       out.println("<html>");
       out.println("<head><title>第一个Servlet程序</title></head> ");
       out.println("<body>");
       out.println("<h3 style=\"color: #0000ff \">Hello,World!</h3>");
       out.println("第一个Servlet程序。");
       out.println("</body>");
       out.println("</html>");
   }
}

