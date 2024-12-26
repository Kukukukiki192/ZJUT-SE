package com.bookstore.servlet;


import com.bookstore.domain.Order;
import com.bookstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过id查询订单
 * @author admin
 *
 */
@WebServlet("/findOrderById")
public class FindOrderByIdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取用户类型
		String type=request.getParameter("type");		
		//2.得到要查询的订单的id
		String id = request.getParameter("id");
		//3.根据id查找订单
		OrderService service = new OrderService();
		Order order = service.findOrderById(id);
        //4.将查询出的订单信息添加到request作用域中
		request.setAttribute("order", order);
		//5.如果用户类型不为null，则请求转发到view.jsp页面，否则转发到orderInfo.jsp页面
		if(type!=null){
			request.getRequestDispatcher("/admin/orders/view.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/client/orderInfo.jsp").forward(request, response);
	}

}
