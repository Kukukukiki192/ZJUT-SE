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
import com.model.User;

//个人信息-修改登录密码
@WebServlet("/Upsw")
public class Upsw extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
        UserDao dao = new UserDao();	
		String U_psw1 = request.getParameter("U_psw1");
		String U_psw2 = request.getParameter("U_psw2");
		HttpSession session = request.getSession();
		User U=(User)session.getAttribute("U");
		String U_psw=U.getU_psw().trim();
		PrintWriter out=response.getWriter();
		
		System.out.println(U_psw+" 原密码"+U_psw1+" 新密码"+U_psw2);//测试
		if(U_psw1.equals(U_psw)){
			U.setU_psw(U_psw2);
			if(dao.pswU(U)) {
				System.out.println("登录密码修改成功");//测试
				out.print("<script language='JavaScript'>alert('修改成功!');window.location.href='1.jsp'</script>");
			}else {
				System.out.println("登录密码修改失败");//测试
				out.print("<script language='JavaScript'>alert('修改失败!');window.location.href='1.jsp'</script>");
			}
		}else out.print("<script language='JavaScript'>alert('原密码不正确!');window.location.href='1.jsp'</script>");					
	}	
}