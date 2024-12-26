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
import com.model.Manager;

@WebServlet("/QueryPeriod")
public class QueryPeriod extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String 	period = request.getParameter("period");
		UserDao dao = new UserDao();
		ArrayList<Manager> List= dao.queryPeriod(period);		
		request.setAttribute("List", List);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Tdescscore1.jsp"); 		
		rd.forward(request, response);		
	}
}
