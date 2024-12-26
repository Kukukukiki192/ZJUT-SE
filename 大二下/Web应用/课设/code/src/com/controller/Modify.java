package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.UserDao;
import com.model.Student;
import com.model.Teacher;

@WebServlet("/Modify")
public class Modify extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int type=Integer.parseInt(request.getParameter("type"));
		int x=Integer.parseInt(request.getParameter("x"));
		String num = request.getParameter("num");
		String num1 = request.getParameter("num1");
		request.setAttribute("type",type);
		request.setAttribute("num", num);
		request.setAttribute("x", x);
		PrintWriter out=response.getWriter();
		if(num.equals(num1)) {
			out.print("<script language='JavaScript'>alert('不可删改本人信息!');window.location.href=");
			if(x==1) {//若在查询结果处修改信息，则修改后跳转到查询信息页面
			 	out.print( "'selectS.jsp?num="+num+"'</script>");
			}else {//若在教师或学生信息处修改信息，则修改后跳转到教师或学生信息页面
			   	out.print( "'AllUser?num="+num+"&type="+type+"'</script>");
			}	   
		}else {
			UserDao dao = new UserDao();
			if(type==1) {
			    Student student = dao.findSByNum(num1);		
				request.setAttribute("student", student);
			}else {
				Teacher teacher = dao.findTByNum(num1);		
				request.setAttribute("teacher", teacher);
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/modifyUser.jsp"); 		
			rd.forward(request, response);	
		}		
	}
}


