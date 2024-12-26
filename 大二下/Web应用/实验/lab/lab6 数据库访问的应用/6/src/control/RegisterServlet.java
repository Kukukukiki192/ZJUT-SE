package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sha256;
import model.Student;
import model.Teacher;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	Connection dbconn = null;
	public void init() {//getConnection
		String driver = "org.postgresql.Driver";
		String dburl = "jdbc:postgresql://127.0.0.1:5432/postgres";
		String username = "postgres";
		String password = "6666";//用自己设置的密码
		try {
			Class.forName(driver);
			dbconn = DriverManager.getConnection(dburl, username, password);
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e2) {
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String ID = request.getParameter("ID");
		String num = request.getParameter("num");
		String password = request.getParameter("password");	
		String psw=Sha256.getSHA256(password);//加密
		String institute = request.getParameter("institute");
		String message = null;
		if(type.equals("教师")) {
			String character= request.getParameter("character");			
			try {//添加注册信息时ID、num不能重复
				String sql = "SELECT * FROM dbt_teacher";
				PreparedStatement pstmt = dbconn.prepareStatement(sql);
				ResultSet rst= pstmt.executeQuery();
				while (rst.next()) {
					if(ID.equals(rst.getString("ID"))||num.equals(rst.getString("num"))) {
						response.sendRedirect("failed.jsp"); return ;
					}
				}//String ==比较地址 equals()比较内容
				//未重复则写入DB
				sql = "INSERT INTO dbt_teacher VALUES (?,?,?,?,?,?) ";
				pstmt = dbconn.prepareStatement(sql); 
				pstmt.setString(1, name);
				pstmt.setString(2, ID);
				pstmt.setString(3, num);
				pstmt.setString(4, psw);
				pstmt.setString(5, institute);
				pstmt.setString(6, character);
				int n = pstmt.executeUpdate();
				if (n>0) {
				message = "<li>注册成功！</li>";
				} else {
				message = "<li>注册失败！</li>"; }
			} catch (SQLException e) {
				e.printStackTrace();
				message = "<li>注册异常！</li>"; 
			}
			Teacher teacher=new Teacher(name,ID,num,psw,institute,character);
			request.getSession().setAttribute("result", message);//直接用请求作用域跳转不了
			request.getSession().setAttribute("teacher",teacher);
			response.sendRedirect("regiResult.jsp");
		}else {
			String major = request.getParameter("major");
			String clas = request.getParameter("clas");
			try {
				String sql = "SELECT * FROM dbt_student";
				PreparedStatement pstmt = dbconn.prepareStatement(sql);
				ResultSet rst= pstmt.executeQuery();
				while (rst.next()) {
					if(ID.equals(rst.getString("ID"))||num.equals(rst.getString("num"))) {
						response.sendRedirect("failed.jsp"); return ;
					}
				}
				//未重复则写入DB
				sql = "INSERT INTO dbt_student VALUES (?,?,?,?,?,?,?) ";
				pstmt = dbconn.prepareStatement(sql); 
				pstmt.setString(1, name);
				pstmt.setString(2, ID);
				pstmt.setString(3, num);
				pstmt.setString(4, psw);
				pstmt.setString(5, institute);
				pstmt.setString(6, major);
				pstmt.setString(7, clas);
				int n = pstmt.executeUpdate();				
				if (n>0) {
				message = "<li>注册成功！</li>";
				} else {
				message = "<li>注册失败！</li>"; }
			} catch (SQLException e) {
				e.printStackTrace();
				message = "<li>注册异常！</li>"; 
			}
			Student student=new Student(name,ID,num,psw,institute,major,clas);
			request.getSession().setAttribute("result", message);
			request.getSession().setAttribute("student",student);
			response.sendRedirect("regiResult.jsp");
		}					
     }
	public void destroy() {
		try {
			dbconn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}