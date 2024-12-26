package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.time.LocalDate;

@WebServlet("/VariableServlet")
public class VariableServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("attrib1", new Integer(250));
		HttpSession session = request.getSession();
		session.setAttribute("attrib2", "Java World!");
		ServletContext application = getServletContext();
		application.setAttribute("attrib3", LocalDate.now());

		request.setAttribute("attrib4", "请求作用域");
		session.setAttribute("attrib4", "会话作用域");
		application.setAttribute("attrib4", "应用作用域");
		// 请求转发到JSP页面
		RequestDispatcher rd = request.getRequestDispatcher("/variables.jsp");
		rd.forward(request, response);
	}
}
