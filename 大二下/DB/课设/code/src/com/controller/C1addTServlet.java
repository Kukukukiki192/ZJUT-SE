package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.*;

@WebServlet("/C1addTServlet")
public class C1addTServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String tno=request.getParameter("tno");
		String tname=request.getParameter("tname");
		String tsex=request.getParameter("tsex");
		Integer tage=Integer.parseInt(request.getParameter("tage"));
		String title=request.getParameter("title");
		String phone=request.getParameter("phone");
		Teacher t= new Teacher(tno,tname,tsex,tage,title,phone);
		String result = null;
		UserDao dao = new UserDao();
		if(dao.addT(t)) result="添加成功！"; 
		else result="添加失败！"; 
	    PrintWriter out=response.getWriter();
	    out.print("<script language='JavaScript'>alert('"+result+"');window.location.href='T'</script>");
	}
}
