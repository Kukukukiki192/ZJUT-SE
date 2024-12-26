package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String psw = request.getParameter("psw");
        UserDao dao = new UserDao();
//        if(dao.Login(type, name, psw)) {
        if(true) {
        	if(type.equals("学生")) {
            	RequestDispatcher rd = getServletContext().getRequestDispatcher("/S.jsp");
    			rd.forward(request, response);
            }else if(type.equals("教师")) {
            	RequestDispatcher rd = getServletContext().getRequestDispatcher("/T.jsp");
    			rd.forward(request, response);
            }else if(type.equals("校级管理员")) {
            	RequestDispatcher rd = getServletContext().getRequestDispatcher("/C1.jsp");
    			rd.forward(request, response);
            }else {//院级管理员
            	RequestDispatcher rd = getServletContext().getRequestDispatcher("/C2.jsp");
    			rd.forward(request, response);
            }
        }
//        request.setAttribute("result", "登录失败!");
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
//		rd.forward(request, response);
	}
}