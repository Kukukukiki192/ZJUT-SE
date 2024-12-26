package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Teacher;

@WebServlet("/queryT.do")
public class QueryT extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num=request.getParameter("num");
		UserDao dao = new UserDao();
		
		Teacher teacher = dao.findTByNum(num);		
		request.setAttribute("teacher", teacher);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showT.jsp");
	    
		rd.forward(request, response);	
	}
}
