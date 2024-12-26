package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/Clockin0")
public class Clockin0 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
		int type=Integer.parseInt(request.getParameter("type"));
		String num = request.getParameter("num");
		request.setAttribute("type",type);
		request.setAttribute("num", num);
		UserDao dao = new UserDao();
		if(dao.Tclockin0()) {
			System.out.println("打卡记录清零成功");//测试
		}
		PrintWriter out=response.getWriter();
		out.print("<script language='JavaScript'>alert('打卡记录清零成功!');window.location.href='clockin.jsp?num="+num+"&type="+type+"'</script>");
		
		
	}
}
