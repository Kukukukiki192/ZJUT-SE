package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Manager;

@WebServlet("/AddScore")
public class AddScore extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String sno=request.getParameter("sno");
		String cno=request.getParameter("cno");
		String period=request.getParameter("period");
		int score = Integer.parseInt(request.getParameter("score"));
		String tname=request.getParameter("tname");
		Manager t= new Manager();
		t.setSno(sno);
		t.setCno(cno);
		t.setPeriod(period);
		t.setScore(score);
		t.setTname(tname);
		String result = null;
		UserDao dao = new UserDao();
		if(dao.addStudy(t)) result="成绩录入成功！"; 
		else result="成绩录入失败！"; 
	    PrintWriter out=response.getWriter();
	    out.print("<script language='JavaScript'>alert('"+result+"');window.location.href='TaddScore.jsp'</script>");				
	}
}
