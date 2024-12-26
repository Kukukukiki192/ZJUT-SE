package com.dao;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;

public class BaseDao {//数据源方式获得一个连接对象
   DataSource dataSource;
    public BaseDao () {
	  try {
	     Context context = new InitialContext();
	     dataSource = (DataSource)context.lookup("java:comp/env/jdbc/sampleDS");//查找JDNI数据源   jdbc/sampleDS-数据源名
	  }catch(NamingException ne){
	      System.out.println("Exception:"+ne);
	  }
	}
	public Connection getConnection()throws Exception{
		return dataSource.getConnection(); 
	}
}