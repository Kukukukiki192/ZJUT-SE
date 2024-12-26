package com.dao;
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;

public interface Dao {
   // 查找并返回数据源对象
   public static DataSource getDataSource(){
	   DataSource dataSource = null;
	   try {
	     Context context = new InitialContext();
	     dataSource = (DataSource)context.lookup("java:comp/env/jdbc/webstoreDS");
	     
	  }catch(NamingException ne){
	     System.out.println("异常:"+ne);
	  }
	  return dataSource;
	}
    // 返回连接对象方法
    public default Connection getConnection() throws DaoException {
	   DataSource dataSource = getDataSource();
	   Connection conn = null;
	   try{
		   conn =  dataSource.getConnection(); 
	   }catch(SQLException sqle){
		   System.out.println("异常:"+sqle);  
	   }
	   return  conn;
   }	
}

