package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Student;
import com.model.Teacher;

@WebServlet("/Query")
public class Query extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		int type=Integer.parseInt(request.getParameter("type")),
			x=Integer.parseInt(request.getParameter("x"));
		String num1 = request.getParameter("num1"),
		       num = request.getParameter("num"),
			   result="";
		request.setAttribute("num", num);
		request.setAttribute("type", type);
		UserDao dao = new UserDao();
		if(type==1) {		
		    Student student = dao.findSByNum(num1);	
		    if(student==null||student.getNum()==null) result="查询失败！";
			request.setAttribute("student", student);		
		}else {
			Teacher teacher = dao.findTByNum(num1);		
			if(teacher==null||teacher.getNum()==null) result="查询失败！";			
			request.setAttribute("teacher", teacher);
		}request.setAttribute("result", result);
		if(x==1) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/showOne.jsp"); 		
			rd.forward(request, response);	
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/statisticsOne.jsp"); 		
			rd.forward(request, response);	
		}	
	}
}
