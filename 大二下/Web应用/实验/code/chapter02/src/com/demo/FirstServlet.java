package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
throws ServletException, IOException {
		String sno = request.getParameter("sno");
		String name = request.getParameter("sname");
		Student student = new Student(sno,name);
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("/SecondServlet");
		rd.forward(request, response);
	  }
}

