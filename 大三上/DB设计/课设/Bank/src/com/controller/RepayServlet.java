package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/RepayServlet")
public class RepayServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();
        HttpSession session = request.getSession();	
		PrintWriter out=response.getWriter();
		String r;
		
		String L_id = request.getParameter("L_id");	//订单号
		String A_id = request.getParameter("A_id");	//还款账户
		String R_money = request.getParameter("R_money");				
		User U = (User)session.getAttribute("U");	
		Timestamp R_time = new Timestamp(System.currentTimeMillis());
		System.out.println("U_id: " + U.getU_id() + " A_id: " + A_id + " R_money: "  + R_money + " R_time: " + R_time);//测试
		Account A=dao.findA(A_id);
			
			if(A.getA_status()==1) {
				r="此账户已挂失,不能进行业务办理!";
			} else {
				Double a=Double.parseDouble(A.getA_money()), b=Double.parseDouble(R_money);
				if( a==0 || a<b ) r="账户余额不足,不能还款!";
				else {
					Repay repay=new Repay(U.getU_id(), A_id, L_id, R_money, R_time);
					if(dao.Repay1(repay) && dao.Repay2(repay)) {
						r="还款成功!";
						
						//更新还款记录
						ArrayList<Repay> Repays;
						Repays = dao.findRepays(U.getU_id());						
						session.setAttribute("Repays", Repays);
						System.out.println("更新还款记录" + Repays);//测试
						
						//更新贷款记录
						ArrayList<Loan> Loans;
						Loans = dao.findLoans(U.getU_id());						
						session.setAttribute("Loans", Loans);
						System.out.println("更新贷款记录"+Loans);//测试
						
						//加入交易记录
						Records record=new Records(U.getU_id(), A_id, "还款", R_money, R_time);
						if(dao.addRecords(record)) System.out.println("录入总记录成功");//测试
						else System.out.println("录入总记录失败");//测试
					}
					else r="还款失败!";				
				}
			}
					
		System.out.println(r);//测试				
		out.print("<script language='JavaScript'>alert('"+ r +"');window.location.href='3repay.jsp'</script>");
	}

}
