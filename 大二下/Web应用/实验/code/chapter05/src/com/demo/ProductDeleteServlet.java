package com.demo;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.model.Product;
@WebServlet("/delete-product")
public class ProductDeleteServlet extends HttpServlet{
   private static final long serialVersionUID = 1L;
   Connection dbconn = null;
   public void init() {
      String driver = "com.mysql.jdbc.Driver";
      String dburl = "jdbc:mysql://127.0.0.1:3306/webstore?useSSL=true";
      String username = "root";
      String password = "123456";
      try{
          Class.forName(driver); // 加载驱动程序
          // 创建连接对象
          dbconn = DriverManager.getConnection(
      	                     dburl,username,password);
      }catch(ClassNotFoundException e1){
          System.out.println(e1);
          getServletContext().log("驱动程序类找不到！");   
      }catch(SQLException e2){
    	  System.out.println(e2);
      }
   }
   
   public void doGet(HttpServletRequest request,
                        HttpServletResponse response)
                        throws ServletException,IOException{
	     String pid = request.getParameter("id"); 
	     try{
          String sql="DELETE FROM products WHERE id =?";
          PreparedStatement pstmt = dbconn.prepareStatement(sql);
          pstmt.setString(1, pid);
         int n  = pstmt.executeUpdate();
         if(n!=0){
             
        	 request.getRequestDispatcher("productquery.do").forward(request, response);
         }else{
            response.sendRedirect("/chapter05/error.jsp");
         }
       }catch(SQLException e){
  	      e.printStackTrace();
       }
   }
   public void destroy(){
	      try {
	         dbconn.close();
	      }catch(Exception e){
		     e.printStackTrace();
      }
   }
}

