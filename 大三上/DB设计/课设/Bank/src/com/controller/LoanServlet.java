package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.*;

@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();
        HttpSession session = request.getSession();	
		PrintWriter out=response.getWriter();
		String r;
		
		String B_city = request.getParameter("B_city");
		String A_id = request.getParameter("A_id");		
		String L_money = request.getParameter("L_money");				
		User U = (User)session.getAttribute("U");	
		Date L_date = new Date(System.currentTimeMillis());
		System.out.println("U_id: " + U.getU_id() + " A_id: " + A_id + " L_money: "  + L_money + " L_date: " + L_date);//测试
		
		Account A=dao.findA(A_id);
		if(A.getA_status()==1) {
			r="此账户已挂失,不能进行业务办理!";
		} else {
		Loan L=new Loan(dao.L_id()+1, U.getU_id(), U.getU_name(), A_id, L_money, dao.B_name(B_city), L_date);
			if(dao.Loan1(L) && dao.Loan2(L)) {
				r="贷款成功!";
				
				//更新贷款记录
				ArrayList<Loan> Loans;
				Loans = dao.findLoans(U.getU_id());	
				session.setAttribute("B_city", B_city);
				session.setAttribute("Loans", Loans);
				System.out.println("更新贷款记录"+Loans);//测试
			}
			else r="贷款失败!";							
		}
		
		System.out.println(r);//测试	
		out.print("<script language='JavaScript'>alert('"+ r +"');window.location.href='3loan.jsp'</script>");
	}

}
