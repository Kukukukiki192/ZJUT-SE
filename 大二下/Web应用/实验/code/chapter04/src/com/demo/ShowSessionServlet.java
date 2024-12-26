package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.time.LocalTime;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ShowSessionServlet")
public class ShowSessionServlet extends HttpServlet{
   public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                       throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      // 创建或返回用户会话对象
      HttpSession session = request.getSession(true); 
      String heading = null;
      // 从会话对象中检索accessCount属性
      Integer accessCount = (Integer)session.getAttribute("accessCount");
      if(accessCount==null){
           accessCount = new Integer(1);
     	 heading = "欢迎您，首次登录该页面！";
      }else{
     	 heading = "欢迎您，再次访问该页面！";
     	 accessCount = accessCount+1;
      }
      // 将accessCount作为属性存储到会话对象中
      session.setAttribute("accessCount",accessCount);
      PrintWriter out = response.getWriter();
      out.println("<html><head>");
      out.println("<title>会话跟踪示例</title></head>");
      out.println("<body><center>");
      out.println("<h4>"+heading
+"<a href='ShowSessionServlet'>再次访问</a>"+"</h4>");
      out.println("<table border='0'>");
      out.println("<tr bgcolor=\"ffad00\"><td>信息</td><td>值</td>\n");
      String state = session.isNew()?"新会话":"旧会话";
      out.println("<tr><td>会话状态：<td>"+state+"\n");
      out.println("<tr><td>会话ID:<td>"+session.getId()+"\n");
      out.println("<tr><td>创建时间:<td>");
      out.println(""+session.getCreationTime()+"\n");
      out.println("<tr><td>最近访问时间:<td>");
      out.println(""+session.getLastAccessedTime()+"\n");
      out.println("<tr><td>最大不活动时间:<td>"+
      session.getMaxInactiveInterval()+"\n");
      out.println("<tr><td>Cookie:<td>"+request.getHeader("Cookie")+"\n");
      out.println("<tr><td>已被访问次数:<td>"+accessCount+"\n");
      out.println("</table>");
      out.println("</center></body></html>");
   }
}

