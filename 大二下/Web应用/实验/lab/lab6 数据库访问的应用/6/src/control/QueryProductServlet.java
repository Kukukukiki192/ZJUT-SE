package control;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Product;
import javax.servlet.annotation.WebServlet;

@WebServlet("/queryproduct.do")
public class QueryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbconn = null;

	public void init() {
		String driver = "org.postgresql.Driver";
		String dburl = "jdbc:postgresql://127.0.0.1:5432/postgres";
		String username = "postgres";
//		String password = "postgres";
		String password = "6666";//用自己设置的密码
		try {
			Class.forName(driver);
			dbconn = DriverManager.getConnection(dburl, username, password);
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e2) {
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productid = request.getParameter("productid");
		try {
			String sql = "SELECT * FROM products WHERE prod_id = ?";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, productid);
			ResultSet rst = pstmt.executeQuery();
			if (rst.next()) {
				Product product = new Product();
				product.setProd_id(rst.getString("prod_id"));//getString(int columnIndex)从1开始.getString(String columnName)
				product.setPname(rst.getString("pname"));
				product.setPrice(rst.getDouble("price"));
				product.setStock(rst.getInt("stock"));
				request.getSession().setAttribute("product", product);
				response.sendRedirect("displayProduct.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> productList = null;
		productList = new ArrayList<Product>();
		try {
			String sql = "SELECT * FROM products";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			ResultSet rst= pstmt.executeQuery();
			while (rst.next()) {
				Product product = new Product();
				product.setProd_id(rst.getString("prod_id"));
				product.setPname(rst.getString("pname"));
				product.setPrice(rst.getDouble("price"));
				product.setStock(rst.getInt("stock"));
				productList.add(product);
			}
			if (!productList.isEmpty()) {
				request.getSession().setAttribute("productList", productList);
				response.sendRedirect("displayAllProduct.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			dbconn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
