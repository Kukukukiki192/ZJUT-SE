package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.UserDao;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		Integer x=Integer.parseInt(request.getParameter("x"));
		String 	no = request.getParameter("no");
		String result="";
		UserDao dao = new UserDao();
		PrintWriter out=response.getWriter();
		if(x==2) {
			if(dao.deleteT(no)) {
				result="删除教师用户成功！"; 
			}else {
				result="删除教师用户失败！"; 
			}
			request.setAttribute("result", result);		
			out.print("<script language='JavaScript'>alert('"+result+"');window.location.href='T'</script>");
		}else {
			if(dao.deleteS(no)) {
				result="删除学生用户成功！"; 
			}else {
				result="删除学生用户失败！"; 
			}
			request.setAttribute("result", result);		
			out.print("<script language='JavaScript'>alert('"+result+"');window.location.href='S'</script>");
		}
	}
}
