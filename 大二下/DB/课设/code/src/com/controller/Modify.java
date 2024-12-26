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

@WebServlet("/Modify")
public class Modify extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		int x=Integer.parseInt(request.getParameter("x"));
		String result=null;
		UserDao dao = new UserDao();
		if(x==1) {
			String  sno = request.getParameter("student_id"),
					sname = request.getParameter("student_name"),
					ssex =request.getParameter("student_sex"),					
					address =request.getParameter("student_address"),					
					bno =request.getParameter("student_bno");
			Integer sage =Integer.parseInt(request.getParameter("student_age")),
					credits=Integer.parseInt(request.getParameter("student_credits"));
			Student student=new Student(sno,sname,ssex,sage,address,credits,bno);
			if(dao.modifyS(student)) {
				result="学生信息修改成功！"; 
			}else {
				result="学生信息修改失败！"; 
			}
		}else {
			String  tno = request.getParameter("teacher_id"),
					tname = request.getParameter("teacher_name"),
					tsex =request.getParameter("teacher_sex"),					
					title =request.getParameter("teacher_title"),
					phone=request.getParameter("teacher_phone");
			Integer tage =Integer.parseInt(request.getParameter("teacher_age"));
			Teacher teacher=new Teacher(tno,tname,tsex,tage,title,phone);
			if(dao.modifyT(teacher)) {
				result="教师信息修改成功！"; 
			}else {
				result="教师信息修改失败！"; 
			}
		}		
		request.setAttribute("result", result);
		PrintWriter out=response.getWriter();
	    out.print("<script language='JavaScript'>alert('"+result+"');window.location.href=");
	    if(x==1) {
	    	out.print( "'S'</script>");
	    }else {
	    	out.print( "'T'</script>");
	    }	    	
	} 
}
