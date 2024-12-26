package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

@WebServlet("/updateproduct.do")
public class UpdateProductServlet extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		String message = null;
		Product product = new Product();	
		String prod_id = request.getParameter("id");
		String pname = request.getParameter("pname");
		double price = Double.parseDouble(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		try {
			String sql = "UPDATE products SET pname=?,price=?,stock=? WHERE prod_id =?";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);		
			pstmt.setString(1, pname);
			pstmt.setDouble(2, price);
			pstmt.setInt(3, stock);
			pstmt.setString(4, prod_id);
			int n = pstmt.executeUpdate();
			product.setProd_id(prod_id);
			product.setPname(pname);
			product.setPrice(price);
			product.setStock(stock);
			if (n>0) {
				message = "<li>更新商品成功！</li>";
			} else {
				message = "<li>更新商品失败！</li>"; }
		} catch (SQLException e) {
			e.printStackTrace();
			message = "<li>更新商品异常！</li>"; 
		}
		request.setAttribute("result", message);
		request.setAttribute("product", product);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateproductresult.jsp");
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
