package com.bookstore.servlet;


import com.bookstore.domain.User;
import com.bookstore.service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取登录页面输入的用户名与密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 2.调用service完成登录操作。
		UserService service =new UserService();
		try {
			User user=service.login(username, password);
			// 3.登录成功，将用户存储到session中.
			request.getSession().setAttribute("user", user);
			// 获取用户的角色，其中用户的角色分普通用户和超级用户两种
			String role = user.getRole();
			// 如果是超级用户，就进入到网上书城的后台管理系统；否则进入我的账户页面
			if(role.equals("超级用户")) {
				response.sendRedirect(request.getContextPath() + "/admin/login/home.jsp");
				return;
			}else {
				response.sendRedirect(request.getContextPath() + "/client/myAccount.jsp");
				return;
			}
		} catch (LoginException e) {
			// 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
			e.printStackTrace();
			request.setAttribute("register_message", e.getMessage());
			RequestDispatcher dispatcher=null;
			dispatcher=this.getServletContext().getRequestDispatcher("/client/login.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
		
	
		
		// 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
