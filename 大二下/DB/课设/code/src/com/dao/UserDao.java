package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.model.*;

public class UserDao extends BaseDao {//所有的数据库操作	
//登录验证
public boolean Login(String type,String name,String psw) {
	String sql = "SELECT * FROM zhukx_登录10";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			if(name.equals(rst.getString(1)) && psw.equals(rst.getString(2)) && type.equals(rst.getString(3))) return true;
		}
	    return false;//没有匹配的用户
	}catch(SQLException ex) {
	    ex.printStackTrace();
	    System.out.println("出现异常");
	    return false;
	}
}
//显示学生信息
public ArrayList<Student> showS() {
	ArrayList<Student> sList = new ArrayList<Student>();
	String sql = "SELECT * FROM zhukx_学生10";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Student s= new Student(rst.getString(1),rst.getString(2),rst.getString(3).trim(),
					rst.getInt(4),rst.getString(5),rst.getInt(6),rst.getString(7));
			sList.add(s);
		}
		return sList;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}	
//显示教师信息
public ArrayList<Teacher> showT() {
	ArrayList<Teacher> sList = new ArrayList<Teacher>();
	String sql = "SELECT * FROM zhukx_教师10";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			System.out.println(rst.getString(5).trim());
			Teacher s= new Teacher(rst.getString(1),rst.getString(2),rst.getString(3).trim(),
					rst.getInt(4),rst.getString(5).trim(),rst.getString(6));
			sList.add(s);
		}
		return sList;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}	
//显示课程信息
public ArrayList<Course> showCourse() {
	ArrayList<Course> List = new ArrayList<Course>();
	String sql = "SELECT * FROM zhukx_课程10";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Course s= new Course(rst.getString(1),rst.getString(2),rst.getString(3),
					rst.getString(4),rst.getInt(5),rst.getString(6),rst.getInt(7));
			List.add(s);
		}
		return List;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}	
//根据编号查找用户
public Teacher queryT(String num) {
	String sql = "SELECT * FROM zhukx_教师10 WHERE zkx_教师编号10=?";
	Teacher t=new Teacher();
	try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, num);
		try (ResultSet rst = pstmt.executeQuery()) {
			if (rst.next()) {
			t= new Teacher(rst.getString(1),rst.getString(2),rst.getString(3).trim(),
				rst.getInt(4),rst.getString(5).trim(),rst.getString(6));
			}	return t;
		}
	} catch (SQLException se) {
		return null;
	}		
}
public Student queryS(String num) {
	String sql = "SELECT * FROM zhukx_学生10 WHERE zkx_学号10=?";
	Student s = new Student();
	try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, num);
		try (ResultSet rst = pstmt.executeQuery()) {
			if (rst.next()) {
				s= new Student(rst.getString(1),rst.getString(2),rst.getString(3).trim(),
					rst.getInt(4),rst.getString(5),rst.getInt(6),rst.getString(7));
			}	return s;
		}
	} catch (SQLException se) {
		return null;
	}		
}
//按班级编号查找开课信息
public ArrayList<Manager> query_kaike(String bno) {
	String sql = "SELECT * FROM 班级课程开设查询  WHERE zkx_班级编号10=?";
	ArrayList<Manager> List = new ArrayList<Manager>();
	try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, bno);
		try (ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Manager c= new Manager();
				c.setBno(rst.getString(1));
				c.setBname(rst.getString(2));
				c.setCno(rst.getString(3));
				c.setCname(rst.getString(4));
				c.setCredit(rst.getInt(5));
				c.setHour(rst.getInt(6));
				List.add(c);
			}
			return List;
		}
	} catch (SQLException se) {
		return null;
	}		
}	
//插入学生信息
public boolean addS(Student S) {
	String sql = "insert into zhukx_学生10 values(?,?,?,?,?,?,?)";
	try (Connection conn = dataSource.getConnection(); 
	  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, S.getSno());
			pstmt.setString(2, S.getSname());
			pstmt.setString(3, S.getSsex());
			pstmt.setInt(4, S.getSage());
			pstmt.setString(5, S.getAddress());
			pstmt.setInt(6, S.getCredits());
			pstmt.setString(7, S.getBno());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("出现异常");
			return false;
		}
}
//插入教师信息
public boolean addT(Teacher T) {
	String sql = "insert into zhukx_教师10 values(?,?,?,?,?,?)";
	try (Connection conn = dataSource.getConnection(); 
	  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, T.getTno());
			pstmt.setString(2, T.getTname());
			pstmt.setString(3, T.getTsex());
			pstmt.setInt(4, T.getTage());
			pstmt.setString(5, T.getTitle());
			pstmt.setString(6, T.getPhone());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("出现异常");
			return false;
		}
}
//按学号删除学生用户
public boolean deleteS(String num) {
	String sql = "delete from zhukx_学生10 WHERE zkx_学号10=?";
	try {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		if (pstmt.executeUpdate() > 0) {
			return true;
		}
	} catch (SQLException se) {
		return false;
	}	return false;
}
//按教师编号删除教师用户
public boolean deleteT(String num) {
	String sql = "delete from zhukx_教师10 WHERE zkx_教师编号10=?";
	try {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		if (pstmt.executeUpdate() > 0) {
			return true;
		}
	} catch (SQLException se) {
		return false;
	}	return false;
}
//修改教师信息
public boolean modifyS(Student student) {
	String sql = "update zhukx_学生10 set zkx_学号10=?,zkx_姓名10=?,zkx_性别10=?,zkx_年龄10=?,zkx_生源地10=?,zkx_已修学分总数10=?,zkx_班级编号10=? where zkx_学号10=?";
	try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, student.getSno());
		pstmt.setString(2, student.getSname());
		pstmt.setString(3, student.getSsex());
		pstmt.setInt(4, student.getSage());
		pstmt.setString(5, student.getAddress());
		pstmt.setInt(6, student.getCredits());
		pstmt.setString(7, student.getBno());
		pstmt.setString(8, student.getSno());
		pstmt.executeUpdate();
		return true;
	} catch (SQLException se) {
		se.printStackTrace();
		System.out.println("出现异常");//测试
		return false;
	}
}
//修改教师信息
public boolean modifyT(Teacher teacher) {
	String sql = "update zhukx_教师10 set zkx_教师编号10=?,zkx_教师姓名10=?,zkx_教师性别10=?,zkx_教师年龄10=?,zkx_职称10=?,zkx_联系电话10=? where zkx_教师编号10=?";
	try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, teacher.getTno());
		pstmt.setString(2, teacher.getTname());
		pstmt.setString(3, teacher.getTsex());
		pstmt.setInt(4, teacher.getTage());
		pstmt.setString(5, teacher.getTitle());
		pstmt.setString(6, teacher.getPhone());
		pstmt.setString(7, teacher.getTno());
		pstmt.executeUpdate();
		return true;
	} catch (SQLException se) {
		se.printStackTrace();
		System.out.println("出现异常");//测试
		return false;
	}
}
//插入"开设"表
public boolean add_kaishe(Manager t) {
	String sql = "insert into zhukx_开设10 values(?,?)";
	try (Connection conn = dataSource.getConnection(); 
	  	PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, t.getCno());
			pstmt.setString(2, t.getBno());
			pstmt.executeUpdate();
			return true;
	} catch (SQLException se) {
		se.printStackTrace();
		System.out.println("出现异常");
		return false;
	}
}
//插入"学习"表
public boolean addStudy(Manager t) {
	String sql = "insert into zhukx_学习10 values(?,?,?,?,?)";
	try (Connection conn = dataSource.getConnection(); 
	  PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, t.getSno());
		pstmt.setString(2, t.getCno());
		pstmt.setString(3, t.getPeriod());
		pstmt.setInt(4, 0);
		pstmt.setString(5, t.getTname());
		pstmt.executeUpdate();
		return true;
	} catch (SQLException se) {
		se.printStackTrace();
		System.out.println("出现异常");
		return false;
	}
}
//显示"开设"表	学院开课信息
public ArrayList<Manager> show_kaishe() {
	ArrayList<Manager> List = new ArrayList<Manager>();
	String sql = "SELECT * FROM zhukx_开设10";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Manager s= new Manager();
			s.setCno(rst.getString(1));
			s.setBno(rst.getString(2));
			List.add(s);
		}
		return List;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}	
//显示"学习"表	学生选课信息
public ArrayList<Manager> showStudy() {
	ArrayList<Manager> List = new ArrayList<Manager>();
	String sql = "SELECT * FROM zhukx_学习10";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Manager s= new Manager();
			s.setSno(rst.getString(1));
			s.setCno(rst.getString(2));
			s.setPeriod(rst.getString(3));
			s.setScore(rst.getInt(4));
			s.setTname(rst.getString(5));
			List.add(s);
		}
		return List;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}	
//显示地区统计
public ArrayList<Student> showAddress() {
	ArrayList<Student> List = new ArrayList<Student>();
	String sql = "SELECT * FROM 地区统计";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Student s= new Student();
			s.setAddress(rst.getString(1));
			s.setSage(rst.getInt(2));
			List.add(s);
		}
		return List;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}




public ArrayList<Manager> SqueryScore11(String num) {
	ArrayList<Manager> List = new ArrayList<Manager>();
	String sql = "SELECT * FROM 学生成绩统计  where zkx_学号10=?";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);){
		pstmt.setString(1, num);
		try(ResultSet rst = pstmt.executeQuery()){
			while (rst.next()) {
				Manager s= new Manager(rst.getString(1),rst.getString(2),"",rst.getString(3),"",
						rst.getString(4),"",rst.getString(5),rst.getString(7),rst.getInt(6),0,rst.getInt(8),0,0);
				List.add(s);
			}
			return List;
		} 		
	}catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}	
}	
	
public ArrayList<Manager> AVGscore() {
	ArrayList<Manager> List = new ArrayList<Manager>();
	String sql = "SELECT * FROM 每门课程平均成绩";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Manager s= new Manager();
			s.setCno(rst.getString(1));
			s.setCname(rst.getString(2));
			s.setAvgscore(rst.getInt(3));
			List.add(s);
		}
		return List;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}	
//总学分		
public Manager SqueryCredit11(String sno) {
	Manager c= new Manager();
	String sql = "SELECT zkx_学号10,zkx_姓名10,zkx_已修学分总数10 FROM zhukx_学生10 where zkx_学号10=?";
	try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, sno);
		try(ResultSet rst = pstmt.executeQuery()){
		if(rst.next()) {			
			c.setSno(rst.getString(1));
			c.setSname(rst.getString(2));
			c.setCredits(rst.getInt(3));			
		}
		return c;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}	
//各科学分	
public ArrayList<Manager> SqueryCredit22() {
	ArrayList<Manager> cList = new ArrayList<Manager>();
	String sql = "SELECT * FROM 学生所学课程及学分统计";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Manager c= new Manager();
			c.setSno(rst.getString(1));
			c.setCname(rst.getString(2));
			c.setCredit(rst.getInt(3));
			cList.add(c);
		}
		return cList;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}		
//教师任课	
public ArrayList<Manager> QueryTeach11() {
	ArrayList<Manager> List = new ArrayList<Manager>();
	String sql = "SELECT * FROM 教师任课查询";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Manager c= new Manager();
			c.setTno(rst.getString(1));
			c.setTname(rst.getString(2));
			c.setCno(rst.getString(3));
			c.setCname(rst.getString(4));
			List.add(c);
		}
		return List;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}		
//班级开课查询
public ArrayList<Manager> show_kaike() {
	ArrayList<Manager> List = new ArrayList<Manager>();
	String sql = "SELECT * FROM 班级课程开设查询";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Manager c= new Manager();
			c.setBno(rst.getString(1));
			c.setBname(rst.getString(2));
			c.setCno(rst.getString(3));
			c.setCname(rst.getString(4));
			c.setCredit(rst.getInt(5));
			c.setHour(rst.getInt(6));
			List.add(c);
		}
		return List;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}		
	
public ArrayList<Manager> DESCscore() {
	ArrayList<Manager> List = new ArrayList<Manager>();
	String sql = "SELECT * FROM 学生成绩统计  order by zkx_成绩10 desc";
	try (Connection conn = dataSource.getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Manager s= new Manager(rst.getString(1),rst.getString(2),"",rst.getString(3),"",
					rst.getString(4),"",rst.getString(5),rst.getString(7),rst.getInt(6),0,rst.getInt(8),0,0);
			List.add(s);
		}
		return List;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}	
	
public ArrayList<Manager> queryCname(String cname) {
	ArrayList<Manager> List = new ArrayList<Manager>();
	String sql = "SELECT * FROM 学生成绩统计  where zkx_课程名称10=? order by zkx_成绩10 desc";
	try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, cname);
		try (ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Manager s= new Manager(rst.getString(1),rst.getString(2),"",rst.getString(3),"",
					rst.getString(4),"",rst.getString(5),rst.getString(7),rst.getInt(6),0,rst.getInt(8),0,0);
			List.add(s);
		}
		return List;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}	

public ArrayList<Manager> queryPeriod(String period) {
	ArrayList<Manager> List = new ArrayList<Manager>();
	String sql = "SELECT * FROM 学生成绩统计  where zkx_开课时间10=? order by zkx_成绩10 desc";
	try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, period);
		try (ResultSet rst = pstmt.executeQuery()) {
		while (rst.next()) {
			Manager s= new Manager(rst.getString(1),rst.getString(2),"",rst.getString(3),"",
					rst.getString(4),"",rst.getString(5),rst.getString(7),rst.getInt(6),0,rst.getInt(8),0,0);
			List.add(s);
		}
		return List;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("出现异常");//测试
		return null;
	}
}
	
	
	
	
	
	
	
	
}
	