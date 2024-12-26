package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Student;
import com.model.Teacher;

@WebServlet("/ModifyPsw")
public class ModifyPsw extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
		int type=Integer.parseInt(request.getParameter("type"));
		String num = request.getParameter("num"), 
			   psw1 = request.getParameter("password1"),
			   psw2 = request.getParameter("password2"),
			   result="";
		PrintWriter out=response.getWriter();
		UserDao dao = new UserDao();
		if(type==1) {
			Student student = dao.findSByNum(num);
			if(student.getPsw().equals(psw1)) {
				student.setPsw(psw2);
				if(dao.modifySpsw(student)) {
					result="修改密码成功!";
					System.out.println("修改密码成功");//测试
				}else {
					result="修改密码失败!";
					System.out.println("修改密码失败");//测试
				}
			}else {
				result="旧密码填写错误!";
			}
		}else {
			Teacher teacher = dao.findTByNum(num);
			if(teacher.getPsw().equals(psw1)) {
				teacher.setPsw(psw2);
				if(dao.modifyTpsw(teacher)) {
					result="修改密码成功!";
					System.out.println("修改密码成功");//测试
				}else {
					result="修改密码失败!";
					System.out.println("修改密码失败");//测试
				}
			}else {
				result="旧密码填写错误!";
			}
		}
		out.print("<script language='JavaScript'>alert('"+result+"');window.location.href='modifyPsw.jsp?num="+num+"&type="+type+"'</script>");						
	}
}
