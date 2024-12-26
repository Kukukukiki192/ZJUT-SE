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

@WebServlet("/Query_kaike")
public class Query_kaike extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String 	bno = request.getParameter("bno");
		UserDao dao = new UserDao();
		ArrayList<Manager> List= dao.query_kaike(bno);		
		request.setAttribute("List", List);
		if(List==null) request.setAttribute("result","查询失败!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/S_kaike.jsp"); 		
		rd.forward(request, response);		
	}
}
