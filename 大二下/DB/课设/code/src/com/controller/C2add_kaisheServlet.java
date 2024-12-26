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

@WebServlet("/C2add_kaisheServlet")
public class C2add_kaisheServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String cno=request.getParameter("cno");
		String bno=request.getParameter("bno");
		Manager t= new Manager();
		t.setCno(cno);
		t.setBno(bno);
		String result = null;
		UserDao dao = new UserDao();
		if(dao.add_kaishe(t)) result="添加成功！"; 
		else result="添加失败！"; 
	    PrintWriter out=response.getWriter();
	    out.print("<script language='JavaScript'>alert('"+result+"');window.location.href='C2_kaisheServlet'</script>");				
	}
}