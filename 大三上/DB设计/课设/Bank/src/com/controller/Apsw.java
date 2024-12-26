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

//修改账户密码
@WebServlet("/Apsw")
public class Apsw extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();	
		String A_psw1 = request.getParameter("A_psw1");
		String A_psw2 = request.getParameter("A_psw2");
		String r;
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		Account A=(Account)session.getAttribute("A");
		
		if(A.getA_status()==1) {
			r="此账户已挂失,不能进行账户管理!";
		} else {
			String A_psw=A.getA_psw().trim();						
			System.out.println(A_psw+" 原密码"+A_psw1+" 新密码"+A_psw2);//测试
			
			if(A_psw1.equals(A_psw)){
				A.setA_psw(A_psw2);
//				session.setAttribute("A", A);//更新会话 不用
				if(dao.pswA(A)) {
					r="修改成功!";
					System.out.println("账户密码修改成功");//测试
				}else {
					r="修改失败!";
					System.out.println("账户密码修改失败");//测试
				}
			}else r="原密码不正确!";
		}
					
		out.print("<script language='JavaScript'>alert('"+ r +"');window.location.href='2detail.jsp'</script>");
	}	
}