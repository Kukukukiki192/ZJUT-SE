package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();
		String U_id = request.getParameter("U_id");		
		String U_psw = request.getParameter("U_psw");
		HttpSession session = request.getSession();				
		
		if(dao.Login(U_id,U_psw)) {
			//查客户
			User U=dao.findU(U_id);		
			session.setAttribute("U", U);
			//查客户账号
			ArrayList<String> A_ids;
			A_ids = dao.findAs(U_id);						
			session.setAttribute("A_ids", A_ids);
			System.out.println(A_ids);//测试
			//获得存款记录
			ArrayList<In> Ins;
			Ins = dao.findIns(U_id);						
			session.setAttribute("Ins", Ins);
			System.out.println("获得存款记录"+Ins);//测试
			//获得取款记录
			ArrayList<Out> Outs;
			Outs = dao.findOuts(U.getU_id());						
			session.setAttribute("Outs", Outs);
			System.out.println("获得取款记录" + Outs);//测试
			//获得转账记录
			ArrayList<Transfer> Transfers;
			Transfers = dao.findTransfers(U.getU_id());						
			session.setAttribute("Transfers", Transfers);
			System.out.println("获得转账记录" + Transfers);//测试
			//获得贷款记录
			ArrayList<Loan> Loans;
			Loans = dao.findLoans(U.getU_id());						
			session.setAttribute("Loans", Loans);
			System.out.println("获得贷款记录"+Loans);//测试
			//获得还款记录
			ArrayList<Repay> Repays;
			Repays = dao.findRepays(U.getU_id());						
			session.setAttribute("Repays", Repays);
			System.out.println("获得还款记录" + Repays);//测试
			
			
			//进入首页
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		} else {
			PrintWriter out=response.getWriter();
		    out.print("<script language='JavaScript'>alert('身份证号或密码错误!');window.location.href='login.jsp'</script>");
		}				
	}	
}
