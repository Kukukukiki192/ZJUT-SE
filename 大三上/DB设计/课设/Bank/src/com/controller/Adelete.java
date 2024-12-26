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
import com.model.*;

@WebServlet("/Adelete")
public class Adelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();
        PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		String r;		
		Account A=(Account)session.getAttribute("A");
		
		if(A.getA_status()==1) {
			r="此账户已挂失,不能进行账户管理!";
		} else {
			System.out.println("余额 " + A.getA_money());//测试
//			if(A.getA_money()==null || A.getA_money()=="" ||  A.getA_money()=="0.0000") {//判断余额是否为空这里有问题
			if(A.getA_money().equals("0.0000")) {//写成这样才对
//				if(dao.deleteA(A.getA_id())) {   deleteAfromU(String A_id, String U_id)
				User U = (User)session.getAttribute("U");
				if(  dao.deleteAfromU(A.getA_id(), U.getU_id()) &&  dao.deleteA(A.getA_id())) {	
				r="删除成功!";
					
					//销户后更新客户账号
//					User U=(User)session.getAttribute("U");
					ArrayList<String> A_ids;
					A_ids = dao.findAs(U.getU_id());						
					session.setAttribute("A_ids", A_ids);
					System.out.println("销户后更新客户账号" + A_ids);//测试
				}
				else r="删除失败!";
			}else r="此账户还有余额,不能删除!";	
		}
							
		out.print("<script language='JavaScript'>alert('"+ r +"');window.location.href='2detail.jsp'</script>");
	}
}
