package com.dao;
import java.sql.*;
import java.util.ArrayList;
import com.model.Customer;
public class CustomerDaoImpl implements CustomerDao{
    // 插入一条客户记录
      public boolean addCustomer(Customer customer) 
              throws DaoException{  	  
   	   String sql = "INSERT INTO customers VALUES(?,?,?,?)";
   	   
   	   try(
   		 Connection conn = getConnection();
   		 PreparedStatement pstmt = conn.prepareStatement(sql))
   	   { 
   		 
   	     pstmt.setInt(1,customer.getId());
   	     pstmt.setString(2,customer.getName());
   	     pstmt.setString(3,customer.getEmail());
   	     pstmt.setDouble(4,customer.getBalance());
   	     pstmt.executeUpdate();
   	     return true;
   	   }catch(SQLException se){
   		System.out.println(se);
   		  return false;
   	   }
   } 
   // 按id查询客户记录
   public Customer findById(int id) throws DaoException{ 
	      String sql = "SELECT id,name,email,balance" +
	  		             " FROM customers WHERE id =?";
      Customer  customer = new Customer();
      try(
    	   Connection conn = getConnection();
    	   PreparedStatement pstmt = conn.prepareStatement(sql)){ 
   	   pstmt.setInt(1,id);
   	   try(ResultSet rst = pstmt.executeQuery()){
   	     if(rst.next()){
   	       customer.setId(rst.getInt("id"));
   	       customer.setName(rst.getString("name"));
   	       customer.setEmail(rst.getString("email"));
   	       customer.setBalance(rst.getDouble("balance"));
   	     }
   	    }
      }catch(SQLException se){
   	  	return null;
   	  }
   	  return customer;
   }
   // 查询所有客户信息
   public ArrayList<Customer> findAllCustomer()throws DaoException{  	  
   	  Customer  customer = new Customer();
   	  ArrayList<Customer> custList = new ArrayList<Customer>();
   	  String sql = "SELECT * FROM customers";
   	  try( 
   		 Connection conn = getConnection();
   		 PreparedStatement pstmt = conn.prepareStatement(sql);
   		 ResultSet rst = pstmt.executeQuery()){  		 
   	      while(rst.next()){
   	        customer.setId(rst.getInt("id"));
   	        customer.setName(rst.getString("name"));
   	        customer.setEmail(rst.getString("email"));
   	        customer.setBalance(rst.getDouble("balance"));	
   	        custList.add(customer);	
   	    }	     
   	     return custList;
   	  }catch(SQLException e){
   	      e.printStackTrace();
   		 return null;
   	  }
   }
}

