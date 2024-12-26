package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Student;
import com.model.Teacher;

@WebServlet("/Query")
public class Query extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		Integer x=Integer.parseInt(request.getParameter("x"));
		String 	no = request.getParameter("no"),result=null;
		UserDao dao = new UserDao();
		if(x==1) {
		    Student s= dao.queryS(no);		
			request.setAttribute("s", s);
			if(s==null) request.setAttribute("result","查询失败!");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentOne.jsp"); 		
			rd.forward(request, response);	
		}else {
			Teacher t= dao.queryT(no);		
			request.setAttribute("t", t);
			if(t==null) request.setAttribute("result","查询失败!");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/TeacherOne.jsp"); 		
			rd.forward(request, response);	
		}		
	}
}