package com.bookstore.servlet;


import com.bookstore.domain.Order;
import com.bookstore.domain.User;
import com.bookstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findOrderByUser")
public class FindOrderByUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取名为“user”的session
		User user = (User) request.getSession().getAttribute("user");
		// 调用service中的方法,根据用户信息查找订单
		OrderService service = new OrderService();
		List<Order> orders = service.findOrderByUser(user);
		// 将订单信息存入request对象的属性orders中。
		request.setAttribute("orders", orders);
		//跳转到orderlist.jsp。
		request.getRequestDispatcher("/client/orderlist.jsp").forward(request, response);
	}
}
