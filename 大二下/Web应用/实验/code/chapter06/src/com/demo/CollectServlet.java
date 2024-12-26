package com.demo;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CollectServlet")
public class CollectServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                     throws ServletException,IOException{
  	  response.setContentType("text/html;charset=UTF-8");
  	  String[] city = {"北京","上海","广州"};
  	  request.setAttribute("mycity", city);
  	
  	  ArrayList<String> fruit = new ArrayList<>();
      fruit.add("apple");
      fruit.add("orange");
      fruit.add("banana");
      request.setAttribute("myFruit", fruit);
 
  	  HashMap<String,String> capital = new HashMap<String,String>();
  	  capital.put("China","北京");
  	  capital.put("England","伦敦");
  	  capital.put("Russia","莫斯科");

  	  request.setAttribute("capital",capital);
  	  RequestDispatcher rd = 
  	          request.getRequestDispatcher("/collections.jsp");
  	  rd.forward(request,response);
   }
}

