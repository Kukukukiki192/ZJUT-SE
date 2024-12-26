package com.demo;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet(
		name = "calculatorServlet", 
		urlPatterns = { "/calculator.do" }, 
		initParams = { 
			@WebInitParam(name = "sleepTime", value = "2000")
		})
public class CalculatorServlet extends HttpServlet{
   private int result;
   private int sleepTime;
   public void init(){
   	  String sleep_time = getInitParameter("sleepTime");
   	  sleepTime = getNumber(sleep_time);
   }
   public void doPost(HttpServletRequest request, 
HttpServletResponse response)
                          throws IOException,ServletException {
      request.setCharacterEncoding("UTF-8");
String value1 = request.getParameter("value1");
      int v1 = getNumber(value1);
      String value2 = request.getParameter("value2");
      int v2 = getNumber(value2);
      String op = request.getParameter("submit");
      if(op.equals("相加")){
     	result = v1 + v2;
      }else{
     	result = v1 - v2;
      }
      try{
     	Thread.sleep(sleepTime);  // 当前线程睡眠指定时间
      }catch(InterruptedException e){
     	log("Exception during sleeping.");
      }
     
      try{
     	response.setContentType("text/html;charset=UTF-8");
     	PrintWriter out = response.getWriter();
     	out.println("<html><body>");
     	out.println(v1 +"与"+ v2 + op +"结果是"+result);
     	out.println("</body></html>");
      }catch(Exception e){
     	log("Error writing output.");
      }
    }
    private int getNumber(String s){
   	  int result = 0;
       try{
   	     result = Integer.parseInt(s);
    	  }catch(NumberFormatException e){
   	    log("Error Parseing "+s);
   	  }
   	  return result;
    }
}

