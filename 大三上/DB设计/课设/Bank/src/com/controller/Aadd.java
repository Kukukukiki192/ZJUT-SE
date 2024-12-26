package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.Account;
import com.model.User;

@WebServlet("/Aadd")
public class Aadd extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();
		String A_id = request.getParameter("A_id");	
		String B_name = request.getParameter("B_name");	
		String A_type = request.getParameter("A_type");	
		String A_psw1 = request.getParameter("A_psw1");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		String r;
		System.out.println("开户:A_id " + A_id + " B_name " + B_name + " A_type " + A_type + "  A_psw1 " + A_psw1);//测试
				
			User U = (User)session.getAttribute("U");
			Account A = new Account(A_id,B_name,A_psw1,A_type);
			if(dao.addA(A) && dao.addAtoU(A_id, U.getU_id())) {
				r="添加成功!";
				
				//开户后更新客户账号
				ArrayList<String> A_ids;
				A_ids = dao.findAs(U.getU_id());						
				session.setAttribute("A_ids", A_ids);
				System.out.println("开户后更新客户账号" + A_ids);//测试
			}
			else r="添加失败!";						
		
		out.print("<script language='JavaScript'>alert('"+ r +"');window.location.href='2.jsp'</script>");
										
	}	
}
