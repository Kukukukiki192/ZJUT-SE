package com.demo;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.model.Product;
@WebServlet("/productquery2.do")
public class ProductQueryServlet2 extends HttpServlet{
   private static final long serialVersionUID = 1L;
   Connection dbconn = null;
   public void init() {
      String driver = "com.mysql.jdbc.Driver";
      String dburl = "jdbc:mysql://127.0.0.1:3306/webstore";
      String username = "root";
      String password = "12345";
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
      String productid = request.getParameter("productid");
      try{
        String sql="SELECT * FROM products WHERE id = ?";
        PreparedStatement pstmt = dbconn.prepareStatement(sql);
        pstmt.setString(1,productid);
        ResultSet rst = pstmt.executeQuery();
        if(rst.next()){
           Product product = new Product();
           product.setId(rst.getInt("id"));
           product.setPname(rst.getString("pname"));
           product.setBrand(rst.getString("brand"));
           product.setPrice(rst.getFloat("price"));
           product.setStock(rst.getInt("stock"));
           request.getSession().setAttribute("product", product);
           response.sendRedirect("/chapter05/displayProduct.jsp");
        }else{
           response.sendRedirect("/chapter05/error.jsp");
        }	
      }catch(SQLException e){
  	      e.printStackTrace();
      }
   }
  
   public void doGet(HttpServletRequest request,
                        HttpServletResponse response)
                        throws ServletException,IOException{
	     ArrayList<Product> productList = null; 
	     productList = new ArrayList<Product>();
	     try{
         String sql="SELECT * FROM products";
         PreparedStatement pstmt = dbconn.prepareStatement(sql);
         ResultSet result = pstmt.executeQuery();
         while(result.next()){
            Product product = new Product();
            product.setId(result.getInt("id"));
            product.setPname(result.getString("pname"));
            product.setBrand(result.getString("brand"));
            product.setPrice(result.getFloat("price"));
            product.setStock(result.getInt("stock"));
            productList.add(product);
         }
         if(!productList.isEmpty()){
    	       request.getSession().setAttribute("productList",productList);
            response.sendRedirect("/chapter05/displayAllProduct.jsp");
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

