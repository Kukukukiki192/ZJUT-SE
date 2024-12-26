package com.bookstore.servlet;


import com.bookstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	// 获得订单号数据
			String orderid = request.getParameter("orderid");
			String paySuccess = "恭喜您支付成功！";
			if (null != orderid) {
					OrderService service = new OrderService();
					// 根据订单号修改订单状态
					try {
						service.updateState(orderid);
						request.setAttribute("paySuccess", paySuccess);
						request.getRequestDispatcher("/findOrderByUser").forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
						response.getWriter().write("修改订单状态失败");
					}
				}
	}
}
