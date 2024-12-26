package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

@WebServlet("/Register")
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();
		String U_id = request.getParameter("U_id");	
		String U_name = request.getParameter("U_name");	
		String U_phone = request.getParameter("U_phone");	
		String U_city = request.getParameter("U_city");	
		String U_psw1 = request.getParameter("U_psw1");
		PrintWriter out=response.getWriter();
		
		User U = new User(U_id,null,U_name,U_phone,U_city,U_psw1);
		if(dao.addU(U)) {
			out.print("<script language='JavaScript'>alert('注册成功!');;window.location.href='login.jsp'</script>");
		}else {
			out.print("<script language='JavaScript'>alert('注册失败!');;window.location.href='register.jsp'</script>");
		}									
	}	
}
