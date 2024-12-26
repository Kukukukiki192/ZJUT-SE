package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.model.Customer;
import com.model.Student;
import com.model.Teacher;

public class UserDao extends BaseDao {//所有的数据库操作	
	// 1.添加教师
	public boolean addTeacher(Teacher teacher) {
		String sql = "INSERT INTO dbt_teacher VALUES(?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teacher.getName());
			pstmt.setString(2, teacher.getID());
			pstmt.setString(3, teacher.getNum());
			pstmt.setString(4, teacher.getPsw());
			pstmt.setString(5, teacher.getInstitute());
			pstmt.setString(6, teacher.getCharacter());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}	
	// 2.添加学生
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO dbt_student VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); 
	  		PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getID());
			pstmt.setString(3, student.getNum());
			pstmt.setString(4, student.getPsw());
			pstmt.setString(5, student.getInstitute());
			pstmt.setString(6, student.getMajor());
			pstmt.setString(7, student.getClas());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	// 3.批量添加教师
	public boolean addTlist(ArrayList<Teacher> tList) {
		Teacher teacher = new Teacher();					
		int i=0;
		String sql = "INSERT INTO dbt_teacher VALUES(?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection()) {
			while(i<tList.size()) {
				teacher = tList.get(i++);					
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, teacher.getName());
				pstmt.setString(2, teacher.getID());
				pstmt.setString(3, teacher.getNum());
				pstmt.setString(4, teacher.getPsw());
				pstmt.setString(5, teacher.getInstitute());
				pstmt.setString(6, teacher.getCharacter());
				pstmt.executeUpdate();
			} 
		}catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
				return true;
	}
	// 4.批量添加学生
	public boolean addSlist(ArrayList<Student> sList) {
		Student student = new Student();					
		int i=0;
		String sql = "INSERT INTO dbt_student VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection()) {
			while(i<sList.size()) {
				student = sList.get(i++);					
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, student.getName());
				pstmt.setString(2, student.getID());
				pstmt.setString(3, student.getNum());
				pstmt.setString(4, student.getPsw());
				pstmt.setString(5, student.getInstitute());
				pstmt.setString(6, student.getMajor());
				pstmt.setString(7, student.getClas());
				pstmt.executeUpdate();
			} 
		}catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
		return true;
	}			
	// 5.根据工号、密码查找配对的系统管理员
	public Teacher findByNum_Psw(String num,String psw) {
			String sql = "SELECT * FROM dbt_teacher WHERE num=? AND password=? AND character='系统管理员'";
			Teacher teacher = new Teacher();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, num);
				pstmt.setString(2, psw);
				try (ResultSet rst = pstmt.executeQuery()) {
					if (rst.next()) {
						teacher.setName(rst.getString("name"));
						teacher.setID(rst.getString("ID"));
						teacher.setNum(rst.getString("num"));
						teacher.setPsw(rst.getString("password"));
						teacher.setInstitute(rst.getString("institute"));
						teacher.setCharacter(rst.getString("character"));
					}
				}	return teacher;
			} catch (SQLException se) {
				return null;
			}			
		}
	
	// 6.根据工号查找教师
	public Teacher findTByNum(String num) {
		String sql = "SELECT * FROM dbt_teacher WHERE num=?";
		Teacher teacher = new Teacher();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, num);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					teacher.setName(rst.getString("name"));
					teacher.setID(rst.getString("ID"));
					teacher.setNum(rst.getString("num"));
					teacher.setPsw(rst.getString("password"));
					teacher.setInstitute(rst.getString("institute"));
					teacher.setCharacter(rst.getString("character"));
				}	return teacher;
			}
		} catch (SQLException se) {
			return null;
		}		
	}
	// 7.根据学号查找学生
	public Student findSByNum(String num) {
		String sql = "SELECT * FROM dbt_student WHERE num=?";
		Student student = new Student();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, num);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					student.setName(rst.getString("name"));
					student.setID(rst.getString("ID"));
					student.setNum(rst.getString("num"));
					student.setPsw(rst.getString("password"));
					student.setInstitute(rst.getString("institute"));
					student.setMajor(rst.getString("major"));
					student.setClas(rst.getString("class"));
				}	return student;
			}
		} catch (SQLException se) {
			return null;
		}		
	}
	// 8.根据学院、专业、班级查找学生
	public ArrayList<Student> findSByIn_M_C(String institute,String major,String clas) {
		ArrayList<Student> sList = new ArrayList<Student>();
		String sql = "SELECT * FROM dbt_student WHERE institute=? AND major=? AND class=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, institute);
			pstmt.setString(2, major);
			pstmt.setString(3, clas);//一定要注意pstmt.setString()和ResultSet rst = pstmt.executeQuery()的顺序
			try (ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Student student = new Student(rst.getString("name"),rst.getString("ID"),rst.getString("num"),
					rst.getString("password"),rst.getString("institute"),rst.getString("major"),rst.getString("class"));
				sList.add(student);
			}
			}
			return sList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	// 9.查找所有教师
	public ArrayList<Teacher> findAllTeacher() {
		ArrayList<Teacher> tList = new ArrayList<Teacher>();
		String sql = "SELECT * FROM dbt_teacher";
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Teacher teacher = new Teacher(rst.getString("name"),rst.getString("ID"),rst.getString("num"),
						rst.getString("password"),rst.getString("institute"),rst.getString("character"));
				tList.add(teacher);
			}
			return tList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	// 10.查找所有学生
	public ArrayList<Student> findAllStudent() {
		ArrayList<Student> sList = new ArrayList<Student>();
		String sql = "SELECT * FROM dbt_student";
		try (Connection conn = dataSource.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Student student = new Student(rst.getString("name"),rst.getString("ID"),rst.getString("num"),
				rst.getString("password"),rst.getString("institute"),rst.getString("major"),rst.getString("class"));
				sList.add(student);
			}
			return sList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
		// 6.修改教师信息
		public boolean modifyTeacher(Teacher teacher) {
			String sql = "update dbt_teacher set institute=? where num=?";
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, teacher.getInstitute());
				pstmt.setString(2, teacher.getNum());
				pstmt.executeUpdate();
				return true;
			} catch (SQLException se) {
				se.printStackTrace();
				return false;
			}
		}
		// 6.修改学生信息
		public boolean modifyStudent(Student student) {
			String sql = "update dbt_student set institute=?,major=?,class=? where num=?";
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, student.getInstitute());
				pstmt.setString(2, student.getMajor());
				pstmt.setString(3, student.getClas());
				pstmt.setString(4, student.getNum());
				pstmt.executeUpdate();
				return true;
			} catch (SQLException se) {
				se.printStackTrace();
				return false;
			}
		}
		// 7.根据工号删除教师信息
		public boolean deleteTeacher(String num) {
			String sql = "delete from dbt_teacher WHERE num=?";
			try {
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num);
				if (pstmt.executeUpdate() > 0) {
					return true;
				}
			} catch (SQLException se) {
				return false;
			}
			return false;
		}
		// 7.根据学号删除学生信息
		public boolean deleteStudent(String num) {
			String sql = "delete from dbt_student WHERE num=?";
			try {
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num);
				if (pstmt.executeUpdate() > 0) {
					return true;
				}
			} catch (SQLException se) {
				return false;
			}
			return false;
		}
}
