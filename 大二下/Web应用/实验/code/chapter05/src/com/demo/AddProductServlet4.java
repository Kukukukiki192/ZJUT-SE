package com.demo;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.model.Product;
@WebServlet("/add-product")
public class AddProductServlet4 extends HttpServlet{
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
   public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                 throws ServletException,IOException{
      String id = request.getParameter("id");
      String pname = request.getParameter("pname");
      String brand = request.getParameter("brand");
      float price = Float.parseFloat(request.getParameter("price"));
      int stock = Integer.parseInt(request.getParameter("stock"));
      
      String result="";
      try{
        String sql="INSERT INTO products VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = dbconn.prepareStatement(sql);
        
        pstmt.setString(1,id);
        pstmt.setString(2,pname);
        pstmt.setString(3,brand);
        pstmt.setFloat(4,price);
        pstmt.setInt(5,stock);
        
        int n = pstmt.executeUpdate();
        if(n==1){
           result="成功插入一条记录";
       
        }else{
        	result="插入记录失败";
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("addProduct.jsp").forward(request, response);
        
      }catch(SQLException e){
    	  result="发生错误";
    	  request.setAttribute("result", result);
          request.getRequestDispatcher("addProduct.jsp").forward(request, response);
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

