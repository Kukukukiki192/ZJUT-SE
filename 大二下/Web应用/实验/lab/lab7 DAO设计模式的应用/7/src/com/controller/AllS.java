package com.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.UserDao;
import com.model.Student;

@WebServlet("/allS.do")
public class AllS extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		ArrayList<Student> student = dao.findAllStudent();
		request.setAttribute("student", student);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showAllS.jsp");
		rd.forward(request, response);
	}
}
