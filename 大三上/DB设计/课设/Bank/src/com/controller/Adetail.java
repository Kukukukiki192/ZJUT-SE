package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.Account;
import com.model.Branch;
import com.model.Records;
import com.model.User;

@WebServlet("/Adetail")
public class Adetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		          	
		String A_id =  request.getParameter("A_id");	
		UserDao dao = new UserDao(); 
		Account A=dao.findA(A_id);
		Branch B=dao.findB(A.getB_name());
				
		HttpSession session = request.getSession();	
		session.setAttribute("A", A);
		session.setAttribute("B", B);
		User U = (User)session.getAttribute("U");
		
		//获得总记录
		ArrayList<Records> Records;
		Records = dao.findRecords(U.getU_id(), A_id);						
		session.setAttribute("Records", Records);
		System.out.println("获得总记录" + Records);//测试
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/2detail.jsp");
		rd.forward(request, response);	
	}
}
