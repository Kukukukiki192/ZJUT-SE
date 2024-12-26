package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sha256;
import model.Teacher;
import model.Student;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
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
		String num = request.getParameter("num");
        String password = request.getParameter("password");
        String psw=Sha256.getSHA256(password);//加密
        String message = null;  
        int flag=0;
        if(type.equals("教师")) {          	
			try {
				String sql = "SELECT * FROM dbt_teacher";
				PreparedStatement pstmt = dbconn.prepareStatement(sql);
				ResultSet rst= pstmt.executeQuery();				
				while (rst.next()) {
					if(num.equals(rst.getString("num"))&&psw.equals(rst.getString("password"))) {
						flag=1;
						message = "<li>登录成功！</li>";
						Teacher teacher=new Teacher(rst.getString("name"),rst.getString("ID"),num,psw,rst.getString("institute"),rst.getString("character"));
						request.getSession().setAttribute("teacher",teacher);
						break;
					}
				}
				if(flag==0) {
					message = "<li>登录失败！</li>";				
				}
			}catch (SQLException e) {
				e.printStackTrace();
				message = "<li>登录异常！</li>"; 
			}			
			request.getSession().setAttribute("result", message);
			if(flag==1) response.sendRedirect("teacher.jsp");
        }else {
			try {
				String sql = "SELECT * FROM dbt_student";
				PreparedStatement pstmt = dbconn.prepareStatement(sql);
				ResultSet rst= pstmt.executeQuery();				
				while (rst.next()) {
					if(num.equals(rst.getString("num"))&&psw.equals(rst.getString("password"))) {
						flag=1;
						message = "<li>登录成功！</li>";
						Student student=new Student(rst.getString("name"),rst.getString("ID"),num,psw,rst.getString("institute"),rst.getString("major"),rst.getString("class"));
						request.getSession().setAttribute("student",student);
						break;
					}
				}
				if(flag==0) {
					message = "<li>登录失败！</li>";				
				}
			}catch (SQLException e) {
				e.printStackTrace();
				message = "<li>登录异常！</li>"; 
			}			
			request.getSession().setAttribute("result", message);
			if(flag==1) response.sendRedirect("student.jsp");
        }
        if(flag==0) response.sendRedirect("error.jsp");
	}
	public void destroy() {
		try {
			dbconn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
