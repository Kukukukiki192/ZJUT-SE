package control;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Product;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addndrop.do")
public class AddnDropProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbconn = null;
	public void init() {//getConnection
		String driver = "org.postgresql.Driver";
		String dburl = "jdbc:postgresql://127.0.0.1:5432/postgres";
		String username = "postgres";
		String password = "6666";//用自己设置的密码
		try {
			Class.forName(driver);
			dbconn = DriverManager.getConnection(dburl, username, password);
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e2) {
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//添加商品提交表单->doPost
		request.setCharacterEncoding("utf-8");
		String message = null;
		Product product = new Product();	
		String prod_id = request.getParameter("prod_id");
		String pname = request.getParameter("pname");
		double price = Double.parseDouble(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		try {
			String sql = "INSERT INTO products VALUES (?, ?, ?, ?) ";
			PreparedStatement pstmt = dbconn.prepareStatement(sql); 
			pstmt.setString(1, prod_id);
			pstmt.setString(2, pname);
			pstmt.setDouble(3, price);
			pstmt.setInt(4, stock);
			int n = pstmt.executeUpdate();
			product.setProd_id(prod_id);
			product.setPname(pname);
			product.setPrice(price);
			product.setStock(stock);
			if (n>0) {
			message = "<li>添加商品成功！</li>";
			} else {
			message = "<li>添加商品失败！</li>"; }
		} catch (SQLException e) {
			e.printStackTrace();
			message = "<li>添加商品异常！</li>"; 
		}
			request.setAttribute("result", message);
			request.setAttribute("product", product);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/addproductresult.jsp");
			rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//超链接传递参数->doGet
		request.setCharacterEncoding("utf-8");
		String message = null;	
		String prod_id = request.getParameter("id");
		try {
			String sql = "DELETE FROM products WHERE prod_id=?";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, prod_id);
			int n = pstmt.executeUpdate();
			if (n>0) {
				message = "<li>删除商品成功！</li>";
			} else {
				message = "<li>删除商品失败！</li>"; }
		} catch (SQLException e) {
			e.printStackTrace();
			message = "<li>删除商品异常！</li>"; 
		}
		request.setAttribute("result", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/dropproductresult.jsp");
		rd.forward(request, response);
	}
	public void destroy() {
		try {
			dbconn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
