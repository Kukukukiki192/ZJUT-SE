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

@WebServlet("/S")
public class S extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		UserDao dao = new UserDao();
		ArrayList<Student> sList =dao.showS();
		if(sList==null) {
			request.setAttribute("result", "查询失败!");
		} else {
			request.setAttribute("sList", sList);		
		}	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student.jsp");
		rd.forward(request, response);	
	}
}
