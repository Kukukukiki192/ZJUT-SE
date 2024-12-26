package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Product;

// 这里省略了若干导入语句
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
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
	      }catch(SQLException e2){
	    	  System.out.println(e2);
	      }
	   }
  
	   public void doGet(HttpServletRequest request,
	                        HttpServletResponse response)
	                        throws ServletException,IOException{
		     ArrayList<Product> prodList = null; 
		     prodList = new ArrayList<Product>();
		     try{
	           String sql="SELECT * FROM products WHERE id < 104";
	           PreparedStatement pstmt = dbconn.prepareStatement(sql);
	           ResultSet result = pstmt.executeQuery();
	           while(result.next()){
	              Product product = new Product();
	              product.setId(result.getInt("id"));
	              product.setPname(result.getString("pname"));
              product.setBrand(result.getString("brand"));
	              product.setPrice(result.getFloat("price"));
	              product.setStock(result.getInt("stock"));
	              prodList.add(product);
	          }
	          if(!prodList.isEmpty()){
	    	        request.getSession().setAttribute("prodList",prodList);
	             response.sendRedirect("/chapter07/showProduct.jsp");
	          }else{
	             response.sendRedirect("/chapter07/error.jsp");
	         }
	       }catch(SQLException e){
	  	      e.printStackTrace();
	       }
	   }
}

