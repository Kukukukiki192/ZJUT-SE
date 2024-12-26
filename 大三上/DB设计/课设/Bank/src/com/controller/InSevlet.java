package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.*;

@WebServlet("/InSevlet")
public class InSevlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();
        HttpSession session = request.getSession();	
		PrintWriter out=response.getWriter();
		String r;
		
		String A_id = request.getParameter("A_id");		
		String I_money = request.getParameter("I_money");				
		User U = (User)session.getAttribute("U");	
		Timestamp I_time = new Timestamp(System.currentTimeMillis());
		System.out.println("U_id: " + U.getU_id() + " A_id: " + A_id + " I_money: "  + I_money + " I_time: " + I_time);//测试
		
		Account A=dao.findA(A_id);
		
		if(A.getA_status()==1) {
			r="此账户已挂失,不能进行业务办理!";
		} else {
			In in=new In(U.getU_id(), A_id, I_money, I_time);
			if(dao.In1(in) && dao.In2(in)) {
				r="存款成功!";
				
				//更新存款记录
				ArrayList<In> Ins;
				Ins = dao.findIns(U.getU_id());						
				session.setAttribute("Ins", Ins);
				System.out.println("更新存款记录"+Ins);//测试
				
				//加入交易记录
				Records record=new Records(U.getU_id(), A_id, "存款", I_money, I_time);
				if(dao.addRecords(record)) System.out.println("存款录入总记录成功");//测试
				else System.out.println("存款录入总记录失败");//测试
				
			}
			else r="存款失败!";							
		}
		
		System.out.println(r);//测试	
		out.print("<script language='JavaScript'>alert('"+ r +"');window.location.href='3in.jsp'</script>");
	}
}
