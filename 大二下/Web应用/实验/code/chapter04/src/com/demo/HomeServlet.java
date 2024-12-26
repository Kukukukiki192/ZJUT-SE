package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) 
                  throws ServletException,IOException{
       HttpSession session = request.getSession();
       response.setContentType("text/html;charset=utf-8");
       PrintWriter out = response.getWriter();

       out.println("<html><body>");
       out.println("点击链接查询:<br>");
       out.println("<a href=\""
            + response.encodeURL("/chapter04/ReportServlet")
            + "\">查询销售报表</a><br>");
       out.println("<a href=\""
           + response.encodeURL("/chapter04/AccountServlet")
           +"\">查看账户信息</a><br>");
       out.println("</body></html>");
    }
}

