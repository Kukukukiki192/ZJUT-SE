package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Student;
import com.model.Teacher;

@WebServlet("/Statistics")
public class Statistics extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String num = request.getParameter("num");
		request.setAttribute("num", num);
		UserDao dao = new UserDao();
		Teacher t = dao.findTByNum(num);
		String	c=t.getCharacter();	
		String	institute=t.getInstitute();
		
		ArrayList<Student> student;
		if(!(c.equals("院级管理员"))) student = dao.findAllS();
		else student = dao.findSByInstitute(institute);
		
		ArrayList<Teacher> teacher;
		if(!(c.equals("院级管理员"))) teacher = dao.findAllT();
		else teacher = dao.findTByInstitute(institute);
		
		request.setAttribute("student", student);			
		request.setAttribute("teacher", teacher);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/statistics.jsp");
		rd.forward(request, response);
	}
}
