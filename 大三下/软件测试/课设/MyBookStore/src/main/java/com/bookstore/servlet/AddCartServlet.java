package com.bookstore.servlet;


import com.bookstore.domain.CartItem;
import com.bookstore.domain.Product;
import com.bookstore.domain.User;
import com.bookstore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.得到商品id
		String id = request.getParameter("id");
		// 2.调用service层方法，根据id查找商品
		ProductService service = new ProductService();
		try {
			Product product= null;
			try {
				product = service.findProductById(id);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
			//3.将商品添加到购物车
			//3.1获得session对象
			HttpSession session =request.getSession();

			// 获取用户信息
			User user = (User) session.getAttribute("user");
			if (user == null){
				response.sendRedirect(request.getContextPath() + "/client/login.jsp");
				return ;
			}

			//3.2从session中获取购物车对象
			Map<String, CartItem> cart =(Map<String, CartItem>)session.getAttribute("cart");
			//3.3如果购物车为null,说明没有商品存储在购物车中，创建出购物车
			if(cart==null) {
				cart=new HashMap<String, CartItem>();
			}
			//3.4如果该商品在购物车存在，就获取在购物车中该商品的信息，如果不存在，则需要存入购物车的商品信息
			Integer count=0;
			CartItem cartItem= new CartItem();
			if( cart.get(id)!=null) {
				cartItem=cart.get(id);
				count = cartItem.getCount();
				count=count+1;
				cartItem.setCount(count);
			}else {
				cartItem.setProduct(product);
				cartItem.setCount(1);
			}
			//3.5将商品信息写入购物车
			cart.put(id, cartItem);
			session.setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
			return;
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
