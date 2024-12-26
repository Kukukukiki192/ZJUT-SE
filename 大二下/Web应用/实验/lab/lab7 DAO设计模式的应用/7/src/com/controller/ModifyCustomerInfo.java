package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;
import com.dao.CustomerDao;;

@WebServlet("/modifyCustomerInfo.do")
public class ModifyCustomerInfo extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cust_id=request.getParameter("cust_id");
		String cname=request.getParameter("cname");
		String email=request.getParameter("email");
		String balance=request.getParameter("balance");
		Customer customer=new Customer();
		customer.setCust_id(cust_id);
		customer.setCname(cname);
		customer.setEmail(email);
		customer.setBalance(Double.parseDouble(balance));
		CustomerDao dao = new CustomerDao();
		String message="";
		if(dao.modifyCustomer(customer)) {
			message="客户信息修改成功！"; 
		}else {
			message="客户信息修改失败！"; 
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/modifyCustomerResult.jsp");
		rd.forward(request, response);
		} 
}