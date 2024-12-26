package com.dao;

import java.util.*;
import java.sql.*;
import com.model.Student;

public class StudentDaoImpl implements StudentDao {
    
    // 添加学生方法
	public boolean addStudent(Student s) throws DaoException{
		Connection conn = getConnection();
		String sql = "INSERT INTO student(sno,sname,sage,major) VALUES (?,?,?,?)"; 
	       try{
	  	     PreparedStatement pstmt = conn.prepareStatement(sql);
	          pstmt.setString(1, s.getSno());
	          pstmt.setString(2, s.getSname());
	          pstmt.setInt(3, s.getSage());
	          pstmt.setString(4,s.getMajor());
	          pstmt.executeUpdate();
	          return true;
	       }catch(SQLException sqle){
	   	      System.out.println(sqle);
	   	      return false;
	        }        
    }
    // 检索学生方法
   public List<Student> listStudent() throws DaoException{
	  Connection conn = getConnection();
  	  String sql = "SELECT * FROM student"; 
  	  List<Student> list = new ArrayList<Student>(); 
  	  try{
  	  	PreparedStatement pstmt = conn.prepareStatement(sql);
  	     ResultSet rs = pstmt.executeQuery();
  	     while(rs.next()){
  	       int id = rs.getInt("id");
  	       String sno = rs.getString(2);
  	       String sname = rs.getString(3);
  	       int sage = rs.getInt(4);
  	       String major = rs.getString(5);
  	       Student s = new Student();
  	       s.setId(id);
  	       s.setSno(sno);
  	       s.setSname(sname);
  	       s.setSage(sage);
  	       s.setMajor(major);
  	       list.add(s);
  	     }
  	     return list;
  	  }catch(SQLException sqle){
  	   	System.out.println(sqle);
  	   	return null;
  	  }        
    }
    // 删除学生方法
    public int removeStudent(int id) throws DaoException{
    	Connection conn = getConnection();
    	String sql = "DELETE FROM student WHERE id=?";  
      	try{
      	 	PreparedStatement pstmt = conn.prepareStatement(sql);
      	    pstmt.setInt(1, id);
      	    return pstmt.executeUpdate();
      	}catch(SQLException sqle){
      	   	System.out.println(sqle);
      	 	return 0;
      	} 
    }
}

