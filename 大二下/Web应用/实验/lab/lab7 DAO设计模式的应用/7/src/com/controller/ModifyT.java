package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.UserDao;
import com.model.Teacher;

@WebServlet("/modifyT.do")
public class ModifyT extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num=request.getParameter("num");
		UserDao dao = new UserDao();
		
		Teacher teacher = dao.findTByNum(num);		
		request.setAttribute("teacher", teacher);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/modifyT.jsp");
	 		
		rd.forward(request, response);	
	}
}
