package com.controller;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.dao.UserDao;
import com.model.Teacher;

@WebServlet("/allT.do")
public class AllT extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		ArrayList<Teacher> teacher = dao.findAllTeacher();
		request.setAttribute("teacher", teacher);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showAllT.jsp");
		rd.forward(request, response);
	}
}
