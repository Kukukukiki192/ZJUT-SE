package com.controller;

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

import com.model.Customer;
import com.model.Sha256;
import com.model.Student;
import com.model.Teacher;
import com.dao.CustomerDao;
import com.dao.UserDao;

@WebServlet("/addUser.do")
public class AddUser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String ID = request.getParameter("ID");
		String num = request.getParameter("num");
//		String password = request.getParameter("password");	
		String psw=Sha256.getSHA256("1111");//加密
		String institute = request.getParameter("institute");
		String result = null;
		UserDao dao = new UserDao();
		if(type.equals("教师")) {
			String character= request.getParameter("character");
			Teacher teacher = new Teacher(name,ID,num,psw,institute,character);
			if(dao.addTeacher(teacher)) {
				result="添加教师用户成功！"; 
			}else {
				result="添加教师用户失败！"; 
			}
			request.setAttribute("result", result);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/addUser.jsp");
			rd.forward(request, response);							
		}else {
			String major = request.getParameter("major");
			String clas = request.getParameter("clas");
			Student student= new Student(name,ID,num,psw,institute,major,clas);
			if(dao.addStudent(student)) {
				result="添加学生用户成功！"; 
			}else {
				result="添加学生用户失败！"; 
			}
			request.setAttribute("result", result);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/addUser.jsp");
			rd.forward(request, response);	
		}
	}
}