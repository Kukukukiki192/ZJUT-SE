package bank.com.control;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.com.model.Customer;
import bank.com.model.LoginDB;

@WebServlet("LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDB loginDB;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		loginDB = (LoginDB) getServletContext().getAttribute("loginDB");
		if (loginDB == null) {
			loginDB = new LoginDB();
			config.getServletContext().setAttribute("loginDB", loginDB);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email=request.getParameter("Email"); 
		String Password=request.getParameter("Password");
		Customer customer = loginDB.getCustomer(Email, Password);
		if (customer != null) {// 说明存在用户
			request.getSession().setAttribute("customer",customer); // 放到session 里面
			request.getRequestDispatcher("/bank/welcome.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/bank/failed.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}