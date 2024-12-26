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

@WebServlet("/ModifyInfo")
public class ModifyInfo extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		int type=Integer.parseInt(request.getParameter("type")),
			x=Integer.parseInt(request.getParameter("x"));
		String  num = request.getParameter("num"),
				num1 = request.getParameter("num1"),
				name=request.getParameter("name"),	
				ID=request.getParameter("ID"),
				psw=request.getParameter("password"),
				institute=request.getParameter("institute"),	
				phone=request.getParameter("phone"),
				result="";
		UserDao dao = new UserDao();
		if(type==1){
			String major=request.getParameter("major"),
			       clas=request.getParameter("clas");
			Student student=new Student(name,ID,num1,psw,institute,major,clas);
			student.setPhone(phone);		
			if(dao.modifyS(student)) {
				result="学生信息修改成功！"; 
			}else {
				result="学生信息修改失败！"; 
			}
		}else {
			String character=request.getParameter("character");
			Teacher teacher=new Teacher(name,ID,num1,psw,institute,character);
			teacher.setPhone(phone);
			if(dao.modifyT(teacher)) {
				result="教师信息修改成功！"; 
			}else {
				result="教师信息修改失败！"; 
			}
		}
		request.setAttribute("result", result);
		PrintWriter out=response.getWriter();
	    out.print("<script language='JavaScript'>alert('"+result+"');window.location.href=");
	    if(x==1) {//若在查询结果处修改信息，则修改后跳转到查询信息页面
	    	out.print( "'selectS.jsp?num="+num+"'</script>");
	    }else {//若在教师或学生信息处修改信息，则修改后跳转到教师或学生信息页面
	    	out.print( "'AllUser?num="+num+"&type="+type+"'</script>");
	    }	    	
	} 
}
