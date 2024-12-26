package com.bookstore.servlet;

import com.bookstore.domain.Product;
import com.bookstore.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class FindProductById
 */
@WebServlet(name = "findProductById" , urlPatterns = "/findProductById")
public class FindProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProductByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 得到商品的id
		String id=request.getParameter("id");
		//通过id查询商品的信息
		ProductService service = new ProductService();
		Product product = null;
		try {
			product = service.findProductById(id);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		request.setAttribute("p", product);

		//跳转到info.jsp页面
        RequestDispatcher dispacther=null;
        dispacther=this.getServletContext().getRequestDispatcher("/client/info.jsp");
        dispacther.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
