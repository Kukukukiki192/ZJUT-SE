package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/account.do")
public class AccountServlet extends HttpServlet{
   public void doGet(HttpServletRequest request, 
                     HttpServletResponse response)
              throws IOException,ServletException {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<html><head>");
      out.println("<title>Declarative Security Example</title>");
      out.println("</head>");
      out.println("<body>");
      String name = request.getRemoteUser();
      out.println("欢迎您, "+name+"!");
      out.println("<br>能够访问该页面，说明你是管理员（manager）。");
      out.println("</body></html>");
    }

   public void doPost(HttpServletRequest request, 
                      HttpServletResponse response)
             throws IOException, ServletException {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<html><head>");
      out.println("<title>Declarative Security Example</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("欢迎你！");
      out.println("HTTP POST请求对所有用户开放！");
      out.println("</body></html>");
   }
}

