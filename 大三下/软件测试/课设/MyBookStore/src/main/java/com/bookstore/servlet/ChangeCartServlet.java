package com.bookstore.servlet;


import com.bookstore.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


/**
 * Servlet implementation class ChangeCartServlet
 */
@WebServlet("/changeCart")
public class ChangeCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    // 1.得到商品id
				String id = request.getParameter("id");
				// 2.得到要修改的数量
				int count = Integer.parseInt(request.getParameter("count"));
				// 3.从session中获取购物车.
				HttpSession session = request.getSession();
				Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
				CartItem cartItem=cart.get(id);
				
				if (count != 0) {
					cartItem.setCount(count);
					cart.put(id, cartItem);
				} else {
					cart.remove(id);
				}
				response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
				return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
