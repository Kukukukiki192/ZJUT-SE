package com.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import com.model.Customer;
import com.dao.CustomerDao;
import javax.servlet.annotation.WebServlet;

@WebServlet("/allCustomer.do")
public class AllCustomer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao dao = new CustomerDao();
		ArrayList<Customer> customer = dao.findAllCustomer();
		request.setAttribute("customer", customer);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showAllCustomer.jsp");
		rd.forward(request, response);
	}
}
