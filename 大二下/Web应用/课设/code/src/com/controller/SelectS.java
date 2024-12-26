package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Student;

@WebServlet("/SelectS")
public class SelectS extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		request.setAttribute("num", num);
		String institute=request.getParameter("institute");
		String major=request.getParameter("major");
		String clas=request.getParameter("clas");
		System.out.println(institute+major+clas);//测试	
		String result="";
		ArrayList<Student> student;
		UserDao dao = new UserDao();
		if(!(institute.equals("")) && major.equals("") && clas.equals("")) {//String最好不要用==比较 否则运行有错
			student = dao.findSByInstitute(institute);		
		} else if(!(institute.equals("")) && !(major.equals("")) && clas.equals("")) {
			student = dao.findSByIn_M(institute,major);			
		} else  {//String最好不要用==比较 否则运行有错
			student = dao.findSByIn_M_C(institute,major,clas);				
		} 
		if(student==null) result="查询异常！";
		else if(student.size()==0) { result="查询失败！"; }
		else result="查询成功！";
		request.setAttribute("student", student);
		request.setAttribute("result", result);	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showSelectS.jsp"); 			
		rd.forward(request, response);	
	}

}
