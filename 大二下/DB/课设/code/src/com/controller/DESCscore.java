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

@WebServlet("/DESCscore")
public class DESCscore extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		UserDao dao = new UserDao();
		ArrayList<Manager> List =dao.DESCscore();
		if(List==null) {
			request.setAttribute("result", "查询失败!");
		} else {
			request.setAttribute("List", List);		
		}	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Tdescscore.jsp");
		rd.forward(request, response);	
	}
}
