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
import com.model.Student;

@WebServlet("/C1addSServlet")
public class C1addSServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String sno=request.getParameter("sno");
		String sname=request.getParameter("sname");
		String ssex=request.getParameter("ssex");
		Integer sage=Integer.parseInt(request.getParameter("sage"));
		String address=request.getParameter("address");
		Integer credits=Integer.parseInt(request.getParameter("credits"));
		String bno=request.getParameter("bno");
		Student s= new Student(sno,sname,ssex,sage,address,credits,bno);
		String result = null;
		UserDao dao = new UserDao();
		if(dao.addS(s)) result="添加成功！"; 
		else result="添加失败！"; 
	    PrintWriter out=response.getWriter();
	    out.print("<script language='JavaScript'>alert('"+result+"');window.location.href='S'</script>");
	}
}