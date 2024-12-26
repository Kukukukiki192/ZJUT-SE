package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;
import com.model.Customer;

@WebServlet("/modifyCustomer.do")
public class ModifyCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cust_id=request.getParameter("cust_id");
		CustomerDao dao = new CustomerDao();
		Customer customer = dao.findByID(cust_id);		
		request.setAttribute("customer", customer);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/modifyCustomer.jsp");
		rd.forward(request, response);	
	}
}
