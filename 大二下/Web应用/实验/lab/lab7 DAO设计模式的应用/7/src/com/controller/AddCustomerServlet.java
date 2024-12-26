package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.Customer;
import com.dao.CustomerDao;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addCustomer.do")
public class AddCustomerServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao dao = new CustomerDao();
		Customer customer = new Customer();
		String message = null;
		try {
			customer.setCust_id(request.getParameter("cust_id"));
			customer.setCname(new String(request.getParameter("cname").getBytes("iso-8859-1"), "UTF-8"));
			customer.setEmail(new String(request.getParameter("email").getBytes("iso-8859-1"), "UTF-8"));
			customer.setBalance(Double.parseDouble(request.getParameter("balance")));
			boolean success = dao.addCustomer(customer);
			if (success) {
				message = "<li>添加成功！</li>";
			} else {
				message = "<li>添加失败</li>";
			}
		} catch (Exception e) {
			message = "<li>出现异常</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/addCustomer.jsp");
		rd.forward(request, response);
	}
}
