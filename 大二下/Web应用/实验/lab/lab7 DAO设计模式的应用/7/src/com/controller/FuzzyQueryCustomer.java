package com.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import com.model.Customer;
import com.dao.CustomerDao;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fuzzyqueryCustomer.do")
public class FuzzyQueryCustomer extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cname = request.getParameter("cname");
		CustomerDao dao = new CustomerDao();
		ArrayList<Customer> customer = dao.findByFuzzyName(cname);
		request.setAttribute("customer", customer);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showFuzzyQueryCustomer.jsp");
		rd.forward(request, response);
	}
}
