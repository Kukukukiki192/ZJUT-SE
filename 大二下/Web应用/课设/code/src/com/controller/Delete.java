package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.UserDao;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		int type=Integer.parseInt(request.getParameter("type")),
				x=Integer.parseInt(request.getParameter("x"));
		String 	num = request.getParameter("num"),
				num1 = request.getParameter("num1"),
				result="";
		PrintWriter out=response.getWriter();
		if(num.equals(num1)) {
			out.print("<script language='JavaScript'>alert('不可删改本人信息!');window.location.href=");
		}else {
			UserDao dao = new UserDao();
			if(type==1) {
				if(dao.deleteS(num1)) {
					result="删除学生用户成功！"; 
				}else {
					result="删除学生用户失败！"; 
				}
			}else {
				if(dao.deleteT(num1)) {
					result="删除教师用户成功！"; 
				}else {
					result="删除教师用户失败！"; 
				}
			}		
			request.setAttribute("result", result);		
			out.print("<script language='JavaScript'>alert('"+result+"');window.location.href=");
		}
	    if(x==1) {//若在查询结果处修改信息，则修改后跳转到查询信息页面
	    	out.print( "'selectS.jsp?num="+num+"'</script>");
	    }else {//若在教师或学生信息处修改信息，则修改后跳转到教师或学生信息页面
	    	out.print( "'AllUser?num="+num+"&type="+type+"'</script>");
	    }	
	}
}
