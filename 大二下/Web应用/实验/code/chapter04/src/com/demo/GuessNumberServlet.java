package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/GuessNumberServlet")
public class GuessNumberServlet extends HttpServlet{
   public void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {
     int magic = (int)(Math.random()*101);
     HttpSession session = request.getSession();
     // 将随机生成的数存储到会话对象中
     session.setAttribute("num",new Integer(magic));
     
     response.setContentType("text/html;charset=utf-8");
     PrintWriter out = response.getWriter();
     out.println("<html><body>");
     out.println("我想出一个0到100之间的数，请你猜！");
     out.println("<form action='/chapter04/GuessNumberServlet' method='post'>");
     out.println("<input type='text' name='guess' />");
     out.println("<input type='submit' value='确定'/>");
     out.println("</form>");
     out.println("</body></html>");
   }
   
   public void doPost(HttpServletRequest request,
                           HttpServletResponse response)
                       throws ServletException, IOException {
     // 得到用户猜的数
int guess = Integer.parseInt(request.getParameter("guess"));
     HttpSession session = request.getSession();
     // 从会话对象中取出随机生成的数
int magic = (Integer)session.getAttribute("num");
     
     response.setContentType("text/html;charset=utf-8");
     PrintWriter out = response.getWriter();
     out.println("<html><body>");
     if(guess==magic){
     	 session.invalidate(); // 销毁会话对象
     	 out.println("祝贺你，答对了!");
     	 out.println("<a href = '/chapter04/GuessNumberServlet'>再猜一次.</a>");
     }else if(guess>magic){
     	 out.println("太大了! 请重猜!");
     }else{
          out.println("太小了! 请重猜!");
     }
     out.println("<form action='/chapter04/GuessNumberServlet' method='post'>");
     out.println("<input type='text' name='guess' />");
     out.println("<input type='submit' value='确定'/>");
     out.println("</form>");
     out.println("</body></html>");
   }
}

