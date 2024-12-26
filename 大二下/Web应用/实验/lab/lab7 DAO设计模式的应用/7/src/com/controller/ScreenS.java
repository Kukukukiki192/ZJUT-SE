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
import com.model.Student;

@WebServlet("/screenS.do")
public class ScreenS extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String institute=request.getParameter("institute");
		String major=request.getParameter("major");
		String clas=request.getParameter("clas");
		UserDao dao = new UserDao();
		
		ArrayList<Student> student = dao.findSByIn_M_C(institute,major,clas);	
		String result="";
		if(student==null) result="查询失败！";
		else result="查询成功！";
		request.setAttribute("result", result);
		request.setAttribute("student", student);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showScreenS.jsp"); 
		
		rd.forward(request, response);	
	}
}
