package com.demo;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.model.Product;
import com.mchange.v2.c3p0.ComboPooledDataSource;
@WebServlet("/product-query3")
public class ProductQueryServlet3 extends HttpServlet{
   private static final long serialVersionUID = 1L;
   Connection dbconn = null;
   public void init() {
	   try {  
		   ComboPooledDataSource dataSource = new ComboPooledDataSource();//创建连接池实例           
		   dataSource.setDriverClass("com.mysql.jdbc.Driver");//设置连接池连接数据库所需的驱动             
		   dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/webstore?useSSL=true");//设置连接数据库的URL              
		   dataSource.setUser("root");//设置连接数据库的用户名              
		   dataSource.setPassword("123456");//设置连接数据库的密码              
		   dataSource.setMaxPoolSize(40);//设置连接池的最大连接数              
           dataSource.setMinPoolSize(2);//设置连接池的最小连接数              
           dataSource.setInitialPoolSize(10);//设置连接池的初始连接数             
           dataSource.setMaxStatements(100);//设置连接池的缓存Statement的最大数              
           dbconn = dataSource.getConnection();//从连接池返回一个连接对象
	   } catch (Exception e) {  
           e.printStackTrace();  
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

