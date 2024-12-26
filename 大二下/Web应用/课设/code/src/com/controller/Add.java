package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.*;

@WebServlet("/Add")
public class Add extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String num = request.getParameter("num");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String ID = request.getParameter("ID");
		String num1 = request.getParameter("num1");
		String psw = request.getParameter("password");	
		String institute = request.getParameter("institute");
		String result = null;
		UserDao dao = new UserDao();
		if(type.equals("教师")) {
			String character= request.getParameter("character");
			Teacher teacher = new Teacher(name,ID,num1,psw,institute,character);
			if(dao.addTeacher(teacher)) {
				result="添加教师用户成功！"; 
			}else {
				result="添加教师用户失败！"; 
			}							
		}else {
			String major = request.getParameter("major");
			String clas = request.getParameter("clas");
			Student student= new Student(name,ID,num1,psw,institute,major,clas);
			if(dao.addStudent(student)) {
				result="添加学生用户成功！"; 
			}else {
				result="添加学生用户失败！"; 
			}			
		}
		request.setAttribute("result", result);
		request.setAttribute("num", num);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/addUser.jsp");
		rd.forward(request, response);	
	}
}
