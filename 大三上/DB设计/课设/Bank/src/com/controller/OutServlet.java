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

@WebServlet("/OutServlet")
public class OutServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();
        HttpSession session = request.getSession();	
		PrintWriter out=response.getWriter();
		String r;
		
		String A_id = request.getParameter("A_id");		
		String O_money = request.getParameter("O_money");				
		User U = (User)session.getAttribute("U");	
		Timestamp O_time = new Timestamp(System.currentTimeMillis());
		System.out.println("U_id: " + U.getU_id() + " A_id: " + A_id + " O_money: "  + O_money + " O_time: " + O_time);//测试
	
		Account A=dao.findA(A_id);
		if(A.getA_status()==1) {
			r="此账户已挂失,不能进行业务办理!";
		} else {
			Double a=Double.parseDouble(A.getA_money()), b=Double.parseDouble(O_money);
//			if( A.getA_money()==null || A.getA_money()=="" ||  A.getA_money()=="0" || A.getA_money().compareTo(O_money)<0 ) r="账户余额不足,不能取款!";
			if( a==0 || a<b ) r="账户余额不足,不能取款!";
			else {
				Out o=new Out(U.getU_id(), A_id, O_money, O_time);
				if(dao.Out1(o) && dao.Out2(o)) {
					r="取款成功!";
					
					//更新取款记录
					ArrayList<Out> Outs;
					Outs = dao.findOuts(U.getU_id());						
					session.setAttribute("Outs", Outs);
					System.out.println("更新取款记录" + Outs);//测试
					
					//加入交易记录
					Records record=new Records(U.getU_id(), A_id, "取款", O_money, O_time);
					if(dao.addRecords(record)) System.out.println("取款录入总记录成功");//测试
					else System.out.println("取款录入总记录失败");//测试
				}
				else r="取款失败!";				
			}
		}
		
		System.out.println(r);//测试				
		out.print("<script language='JavaScript'>alert('"+ r +"');window.location.href='3out.jsp'</script>");
	}

}
