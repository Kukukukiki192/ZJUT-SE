package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.UserDao;


@WebServlet("/deleteT.do")
public class DeleteT extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num=request.getParameter("num");
		UserDao dao = new UserDao();
		String result="";
		if(dao.deleteTeacher(num)) {
			result="删除教师用户成功！"; 
		}else {
			result="删除教师用户失败！"; 
		}
		request.setAttribute("result", result);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteTRes.jsp");
		rd.forward(request, response);	
	}
}
