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

@WebServlet("/deleteCustomer.do")
public class DeleteCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cust_id=request.getParameter("cust_id");
		CustomerDao dao = new CustomerDao();
		String message="";
		if(dao.deleteCustomer(cust_id)) {
			message="删除客户成功！"; 
		}else {
			message="删除客户失败！"; 
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteCustomerResult.jsp");
		rd.forward(request, response);	
	}
}
