package com.demo;
import java.io.*;
import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import javax.servlet.annotation.WebServlet;
import com.model.Product;
@WebServlet("/product-query")
public class ProductQueryServlet extends HttpServlet{
   private static final long serialVersionUID = 1L; 
   DataSource dataSource;
   public void init() {   
      try{
	      Context context = new InitialContext();
	      dataSource = (DataSource)context.lookup("java:comp/env/jdbc/webstoreDS");  
      }catch(NamingException ne){
          System.out.println(ne);
          getServletContext().log("驱动程序类找不到！");   
      }
   }
   
   public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                 throws ServletException,IOException{
	   Connection dbconn = null;
	   String productid = request.getParameter("productid");
       try{
    	   dbconn = dataSource.getConnection();
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
      }finally {
          try {
 	         dbconn.close();
 	      }catch(Exception e){
 		     e.printStackTrace();
         }
      }
   }
  
   public void doGet(HttpServletRequest request,
                        HttpServletResponse response)
                        throws ServletException,IOException{
	     Connection dbconn = null;  
	     ArrayList<Product> productList = null; 
	     productList = new ArrayList<Product>();
	     try{
	    	 dbconn = dataSource.getConnection();
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
       }finally {
           try {
   	         dbconn.close();
   	      }catch(Exception e){
   		     e.printStackTrace();
           }
        }
   }
}

