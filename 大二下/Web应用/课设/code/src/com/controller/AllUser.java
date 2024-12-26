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
import com.model.*;

@WebServlet("/AllUser")
public class AllUser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int type=Integer.parseInt(request.getParameter("type"));
		String num = request.getParameter("num");
		request.setAttribute("num", num);
		request.setAttribute("type", type);
		UserDao dao = new UserDao();
		Teacher t = dao.findTByNum(num);
		String	c=t.getCharacter();	
		String	institute=t.getInstitute();
		System.out.println(c);//测试	
		if(type==1) {		
			ArrayList<Student> student;
			if(!(c.equals("院级管理员"))) student = dao.findAllS();
			else student = dao.findSByInstitute(institute);
			request.setAttribute("student", student);
		}else {			
			ArrayList<Teacher> teacher;
			if(!(c.equals("院级管理员"))) teacher = dao.findAllT();
			else teacher = dao.findTByInstitute(institute);
			request.setAttribute("teacher", teacher);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showAll.jsp");
		rd.forward(request, response);
	}
}
