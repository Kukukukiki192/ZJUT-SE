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

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();
        HttpSession session = request.getSession();	
		PrintWriter out=response.getWriter();
		String r;
		
		String A_id = request.getParameter("A_id");	
		String A_id1 = request.getParameter("A_id1");		
		String T_money = request.getParameter("T_money");				
		User U = (User)session.getAttribute("U");	
		Timestamp T_time = new Timestamp(System.currentTimeMillis());
		System.out.println("U_id: " + U.getU_id() + " A_id: " + A_id + " A_id1: " + A_id1 + " T_money: "  + T_money + " T_time: " + T_time);//测试
				
			Account A=dao.findA(A_id);
			Double a=Double.parseDouble(A.getA_money()), b=Double.parseDouble(T_money);
//			if( A.getA_money()==null || A.getA_money()=="" ||  A.getA_money()=="0" || A.getA_money().compareTo(T_money)<0 ) r="账户余额不足,不能转账!";
			if( a==0 || a<b ) r="账户余额不足,不能转账!";
			else {
				Transfer t=new Transfer(U.getU_id(), A_id, A_id1, T_money, T_time);
				if(dao.Transfer1(t) && dao.Transfer2(t)) {
					r="转账成功!";
					
					//更新转账记录
					ArrayList<Transfer> Transfers;
					Transfers = dao.findTransfers(U.getU_id());						
					session.setAttribute("Transfers", Transfers);
					System.out.println("更新转账记录" + Transfers);//测试		
					
					//加入交易记录
					Records record=new Records(U.getU_id(), A_id, "转账", T_money, T_time);
					if(dao.addRecords(record)) System.out.println("转账录入总记录成功");//测试
					else System.out.println("转账录入总记录失败");//测试
				
					record.setType("收款");
					if(dao.addRecords(record)) System.out.println("收款录入总记录成功");//测试
					else System.out.println("收款录入总记录失败");//测试
				}
				else r="转账失败!";	
								
			}
		
		System.out.println(r);//测试				
		out.print("<script language='JavaScript'>alert('"+ r +"');window.location.href='3transfer.jsp'</script>");
	}

}
