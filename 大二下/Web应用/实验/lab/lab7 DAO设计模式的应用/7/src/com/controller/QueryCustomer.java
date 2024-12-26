package com.controller;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import com.model.Customer;
import com.dao.CustomerDao;
import javax.servlet.annotation.WebServlet;

@WebServlet("/queryCustomer.do")
public class QueryCustomer extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cname=request.getParameter("cname");
		CustomerDao dao = new CustomerDao();
		Customer customer = dao.findByName(cname);
		request.setAttribute("customer", customer);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showCustomer.jsp");
		rd.forward(request, response);
	}
}
