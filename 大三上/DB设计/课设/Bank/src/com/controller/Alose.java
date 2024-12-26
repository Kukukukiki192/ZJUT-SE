package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.*;

@WebServlet("/Alose")
public class Alose extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();
        PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		String r;
		
		Account A=(Account)session.getAttribute("A");
		if(A.getA_status()==1) r="此账户已挂失!";
		else {
			A.setA_status(1);//挂失->更新状态为1
//			session.setAttribute("A", A);//更新会话
			if(dao.loseA(A.getA_id())) r="挂失成功!";
			else r="挂失失败!";
		}	
		out.print("<script language='JavaScript'>alert('"+ r +"');window.location.href='2detail.jsp'</script>");			
	}
}
