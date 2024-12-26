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

@WebServlet("/QueryTeachServlet")
public class QueryTeachServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String result = null;
		UserDao dao = new UserDao();
		ArrayList<Manager> List =dao.QueryTeach11();
		if(List==null) {
			result="查询失败!"; //System.out.println("查询失败!");
			request.setAttribute("result", result);
		} else {//result="查询成功"; 
			request.setAttribute("List", List);		
		}	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/TqueryTeach.jsp"); 
		rd.forward(request, response);
	}	
}