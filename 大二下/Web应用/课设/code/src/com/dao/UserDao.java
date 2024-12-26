package com.dao;

import java.sql.*;
import java.util.ArrayList;
import com.model.Student;
import com.model.Teacher;

public class UserDao extends BaseDao {//所有的数据库操作	
	//单独添加用户
	public boolean addTeacher(Teacher teacher) {
		String sql = "INSERT INTO dbt_teacher VALUES(?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teacher.getName());
			pstmt.setString(2, teacher.getID());
			pstmt.setString(3, teacher.getNum());
			pstmt.setString(4, teacher.getPsw());
			pstmt.setString(5, teacher.getInstitute());
			pstmt.setString(6, teacher.getCharacter());
			pstmt.setString(7,"无");
			pstmt.setInt(8,0);
			pstmt.setInt(9,0);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}	
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO dbt_student VALUES(?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); 
	  		PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getID());
			pstmt.setString(3, student.getNum());
			pstmt.setString(4, student.getPsw());
			pstmt.setString(5, student.getInstitute());
			pstmt.setString(6, student.getMajor());
			pstmt.setString(7, student.getClas());
			pstmt.setString(8,"无");
			pstmt.setInt(9,0);
			pstmt.setInt(10,0);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	//批量添加用户
	public boolean addTlist(ArrayList<Teacher> tList) {
		Teacher teacher = new Teacher();					
		int i=0;
		String sql = "INSERT INTO dbt_teacher VALUES(?,?,?,?,?,?,?,?,?)";
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
				pstmt.setString(7,"无");
				pstmt.setInt(8,0);
				pstmt.setInt(9,0);
				pstmt.executeUpdate();
			} 
		}catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
				return true;
	}
	public boolean addSlist(ArrayList<Student> sList) {
		Student student = new Student();					
		int i=0;
		String sql = "INSERT INTO dbt_student VALUES(?,?,?,?,?,?,?,?,?,?)";
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
				pstmt.setString(8,"无");
				pstmt.setInt(9,0);
				pstmt.setInt(10,0);
				pstmt.executeUpdate();
			} 
		}catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
		return true;
	}			
	//根据工号、密码查找配对的管理员
	public Teacher findTByNum_Psw(String num,String psw) {
		String sql = "SELECT * FROM dbt_teacher WHERE num=? AND password=?";
		Teacher teacher = new Teacher();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, num);
			pstmt.setString(2, psw);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					teacher.setName(rst.getString("name"));
					teacher.setID(rst.getString("id"));
					teacher.setNum(rst.getString("num"));
					teacher.setPsw(rst.getString("password"));
					teacher.setInstitute(rst.getString("institute"));
					teacher.setCharacter(rst.getString("character"));
					teacher.setPhone(rst.getString("phone"));
					teacher.setClockin(rst.getInt("clockin"));
					teacher.setCode(rst.getString("code"));
				}
			} return teacher;
		} catch (SQLException se) {
			return null;
		}			
	}	
	//根据姓名、学号、密码(身份证号后8位)查找配对的学生和普通教师
	public Student findSByName_Num_Psw(String name,String num,String psw) {
		String sql = "SELECT * FROM dbt_student WHERE name=? AND num=? AND password=?";
		Student student = new Student();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, num);
			pstmt.setString(3, psw);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					student.setName(rst.getString("name"));
					student.setID(rst.getString("id"));
					student.setNum(rst.getString("num"));
					student.setPsw(rst.getString("password"));
					student.setInstitute(rst.getString("institute"));
					student.setMajor(rst.getString("major"));
					student.setClas(rst.getString("class"));
					student.setPhone(rst.getString("phone"));
					student.setClockin(rst.getInt("clockin"));
					student.setCode(rst.getString("code"));
				}
			}	return student;
		} catch (SQLException se) {
			return null;
		}			
	}
	public Teacher findTByName_Num_Psw(String name,String num,String psw) {
		String sql = "SELECT * FROM dbt_teacher WHERE name=? AND num=? AND password=?";
		Teacher teacher = new Teacher();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, num);
			pstmt.setString(3, psw);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					teacher.setName(rst.getString("name"));
					teacher.setID(rst.getString("id"));
					teacher.setNum(rst.getString("num"));
					teacher.setPsw(rst.getString("password"));
					teacher.setInstitute(rst.getString("institute"));
					teacher.setCharacter(rst.getString("character"));
					teacher.setPhone(rst.getString("phone"));
					teacher.setClockin(rst.getInt("clockin"));
					teacher.setCode(rst.getString("code"));
				}
			}	return teacher;
		} catch (SQLException se) {
			return null;
		}			
	}	
	//根据工号/学号查找用户
	public Teacher findTByNum(String num) {
		String sql = "SELECT * FROM dbt_teacher WHERE num=?";
		Teacher teacher = new Teacher();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, num);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					teacher.setName(rst.getString("name"));
					teacher.setID(rst.getString("id"));
					teacher.setNum(rst.getString("num"));
					teacher.setPsw(rst.getString("password"));
					teacher.setInstitute(rst.getString("institute"));
					teacher.setCharacter(rst.getString("character"));
					teacher.setPhone(rst.getString("phone"));
					teacher.setClockin(rst.getInt("clockin"));
					teacher.setCode(rst.getString("code"));
					teacher.setDay(rst.getInt("day"));
					teacher.setDate(rst.getString("date"));
				}	return teacher;
			}
		} catch (SQLException se) {
			return null;
		}		
	}
	public Student findSByNum(String num) {
		String sql = "SELECT * FROM dbt_student WHERE num=?";
		Student student = new Student();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, num);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					student.setName(rst.getString("name"));
					student.setID(rst.getString("id"));
					student.setNum(rst.getString("num"));
					student.setPsw(rst.getString("password"));
					student.setInstitute(rst.getString("institute"));
					student.setMajor(rst.getString("major"));
					student.setClas(rst.getString("class"));
					student.setPhone(rst.getString("phone"));
					student.setClockin(rst.getInt("clockin"));
					student.setCode(rst.getString("code"));
					student.setDay(rst.getInt("day"));
					student.setDate(rst.getString("date"));
				}	return student;
			}
		} catch (SQLException se) {
			return null;
		}		
	}
	//根据学院、专业、班级查找学生
	public ArrayList<Student> findSByIn_M_C(String institute,String major,String clas) {
		ArrayList<Student> sList = new ArrayList<Student>();
		String sql = "SELECT * FROM dbt_student WHERE institute=? AND major=? AND class=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, institute);
			pstmt.setString(2, major);
			pstmt.setString(3, clas);//一定要注意pstmt.setString()和ResultSet rst = pstmt.executeQuery()的顺序
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Student student = new Student(rst.getString("name"),rst.getString("id"),rst.getString("num"),
						rst.getString("password"),rst.getString("institute"),rst.getString("major"),rst.getString("class"));
					student.setPhone(rst.getString("phone"));
					sList.add(student);
				}
			}
			return sList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	//根据学院、专业查找学生
	public ArrayList<Student> findSByIn_M(String institute,String major) {
		ArrayList<Student> sList = new ArrayList<Student>();
		String sql = "SELECT * FROM dbt_student WHERE institute=? AND major=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, institute);
			pstmt.setString(2, major);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Student student = new Student(rst.getString("name"),rst.getString("id"),rst.getString("num"),
						rst.getString("password"),rst.getString("institute"),rst.getString("major"),rst.getString("class"));
					student.setPhone(rst.getString("phone"));
					sList.add(student);
				}
			}
			return sList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}		
	//根据学院查找用户
	public ArrayList<Student> findSByInstitute(String institute) {
		ArrayList<Student> sList = new ArrayList<Student>();
		String sql = "SELECT * FROM dbt_student WHERE institute=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, institute);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Student student = new Student(rst.getString("name"),rst.getString("id"),rst.getString("num"),
						rst.getString("password"),rst.getString("institute"),rst.getString("major"),rst.getString("class"));
					student.setPhone(rst.getString("phone"));
					student.setClockin(rst.getInt("clockin"));
					student.setCode(rst.getString("code"));
					sList.add(student);
				}
			}
			return sList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	public ArrayList<Teacher> findTByInstitute(String institute) {
		ArrayList<Teacher> tList = new ArrayList<Teacher>();
		String sql = "SELECT * FROM dbt_teacher WHERE institute=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, institute);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Teacher teacher = new Teacher(rst.getString("name"),rst.getString("id"),rst.getString("num"),
						rst.getString("password"),rst.getString("institute"),rst.getString("character"));
					teacher.setPhone(rst.getString("phone"));
					teacher.setClockin(rst.getInt("clockin"));
					teacher.setCode(rst.getString("code"));
					tList.add(teacher);
				}
			}
			return tList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//查找所有用户
	public ArrayList<Teacher> findAllT() {
		ArrayList<Teacher> tList = new ArrayList<Teacher>();
		String sql = "SELECT * FROM dbt_teacher";
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Teacher teacher = new Teacher(rst.getString("name"),rst.getString("id"),rst.getString("num"),
						rst.getString("password"),rst.getString("institute"),rst.getString("character"));
				teacher.setPhone(rst.getString("phone"));
				teacher.setClockin(rst.getInt("clockin"));
				teacher.setCode(rst.getString("code"));
				tList.add(teacher);
			}
			return tList;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("出现异常");//测试
			return null;
		}
	}	
	public ArrayList<Student> findAllS() {
		ArrayList<Student> sList = new ArrayList<Student>();
		String sql = "SELECT * FROM dbt_student";
		try (Connection conn = dataSource.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Student student = new Student(rst.getString("name"),rst.getString("id"),rst.getString("num"),
				rst.getString("password"),rst.getString("institute"),rst.getString("major"),rst.getString("class"));
				student.setPhone(rst.getString("phone"));
				student.setClockin(rst.getInt("clockin"));
				student.setCode(rst.getString("code"));
				sList.add(student);
			}
			return sList;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("出现异常");//测试
			return null;
		}
	}
	//修改信息
	public boolean modifyT(Teacher teacher) {
		String sql = "update dbt_teacher set name=?,id=?,password=?,institute=?,character=?,phone=? where num=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teacher.getName());
			pstmt.setString(2, teacher.getID());
			pstmt.setString(3, teacher.getPsw());
			pstmt.setString(4, teacher.getInstitute());
			pstmt.setString(5, teacher.getCharacter());
			pstmt.setString(6, teacher.getPhone());
			pstmt.setString(7, teacher.getNum());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("出现异常");//测试
			return false;
		}
	}
	public boolean modifyS(Student student) {
		String sql = "update dbt_student set name=?,id=?,password=?,institute=?,major=?,class=?,phone=? where num=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getID());
			pstmt.setString(3, student.getPsw());
			pstmt.setString(4, student.getInstitute());
			pstmt.setString(5, student.getMajor());
			pstmt.setString(6, student.getClas());
			pstmt.setString(7, student.getPhone());
			pstmt.setString(8, student.getNum());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("出现异常");//测试
			return false;
		}
	}
	//根据工号/学号删除用户信息
	public boolean deleteT(String num) {
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
		}	return false;
	}
	public boolean deleteS(String num) {
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
		}	return false;
	}	
	//更新健康码颜色、日期、天数、打卡、手机号
	public boolean T5(Teacher teacher) {
		String sql = "update dbt_teacher set code=?,date=?,day=?,clockin=?,phone=? where num=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teacher.getCode());
			pstmt.setString(2, teacher.getDate());
			pstmt.setInt(3, teacher.getDay());
			pstmt.setInt(4, teacher.getClockin());
			pstmt.setString(5, teacher.getPhone());
			pstmt.setString(6,teacher.getNum());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("出现异常");//测试
			return false;
		}
	}
	public boolean S5(Student student) {
		String sql = "update dbt_student set code=?,date=?,day=?,clockin=?,phone=? where num=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getCode());
			pstmt.setString(2, student.getDate());
			pstmt.setInt(3, student.getDay());
			pstmt.setInt(4, student.getClockin());
			pstmt.setString(5, student.getPhone());
			pstmt.setString(6, student.getNum());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("出现异常");//测试
			return false;
		}
	}		
	//修改密码
	public boolean modifyTpsw(Teacher teacher) {
		String sql = "update dbt_teacher set password=? where num=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teacher.getPsw());
			pstmt.setString(2, teacher.getNum());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("出现异常");//测试
			return false;
		}
	}
	public boolean modifySpsw(Student student) {
		String sql = "update dbt_student set password=? where num=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getPsw());
			pstmt.setString(2, student.getNum());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("出现异常");//测试
			return false;
		}
	}
	//打卡记录清零
	public boolean Tclockin0() {
		String sql = "update dbt_teacher set clockin=0";//修改表中所有元组
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("出现异常");//测试
			return false;
		}
	}								
}