package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.*;

@WebServlet("/Ldetail")
public class Ldetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		          	
		String L_id =  request.getParameter("L_id");	
		UserDao dao = new UserDao(); 
		Loan L=dao.findL(L_id);
		HttpSession session = request.getSession();	
		session.setAttribute("L", L);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/3loan_detail.jsp");
		rd.forward(request, response);	
	}
}