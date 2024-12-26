package com.bookstore.servlet;

import com.bookstore.domain.PageBean;
import com.bookstore.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class ShowProductByPageServlet
 */
@WebServlet(name = "ShowProductByPage", urlPatterns = "/showProductByPage")
public class ShowProductByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductByPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     // 1.定义当前页码，默认为1
				int currentPage = 1;
				String _currentPage = request.getParameter("currentPage");
				if (_currentPage != null) {
					currentPage = Integer.parseInt(_currentPage);
				}
				// 2.定义每页显示条数,默认为4
				int currentCount = 4;
				String _currentCount = request.getParameter("currentCount");
				if (_currentCount != null) {
					currentCount = Integer.parseInt(_currentCount);
				}
				// 3.获取查找的分类
				String category = "全部商品";
				String _category = request.getParameter("category");
				if (_category != null) {
					category = _category;
				}
				// 4.调用service，完成获取当前页分页Bean数据.
				ProductService service = new ProductService();
				PageBean bean = service.findProductByPage(currentPage, currentCount,
						category);
				// 将数据存储到request范围，跳转到product_list.jsp页面展示
				request.setAttribute("bean", bean);
				RequestDispatcher dispatcher=null;
				dispatcher=this.getServletContext().getRequestDispatcher("/client/product_list.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
