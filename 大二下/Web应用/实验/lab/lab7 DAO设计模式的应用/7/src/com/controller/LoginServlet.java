package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Sha256;
import com.model.Teacher;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String num = request.getParameter("num");
        String password = request.getParameter("password");
        String psw=Sha256.getSHA256(password);//加密
        UserDao dao = new UserDao();
		Teacher teacher= dao.findByNum_Psw(num,psw);
		String result = null;
		if(teacher==null) { result="登录失败！"; }
		else { result="登录成功！"; }
		request.setAttribute("result", result);
		request.setAttribute("teacher", teacher);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/logRes.jsp");
		rd.forward(request, response);
	}
}
