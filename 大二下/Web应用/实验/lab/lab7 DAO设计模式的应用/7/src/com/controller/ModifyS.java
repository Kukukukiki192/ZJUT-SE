package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.UserDao;
import com.model.Student;

@WebServlet("/modifyS.do")
public class ModifyS extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num=request.getParameter("num");
		UserDao dao = new UserDao();

	    Student student = dao.findSByNum(num);		
		request.setAttribute("student", student);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/modifyS.jsp"); 
		
		rd.forward(request, response);	
	}
}
