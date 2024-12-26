package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Student;

@WebServlet("/modifySInfo.do")
public class ModifySInfo extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num=request.getParameter("num");
		String institute=request.getParameter("institute");	
		String major=request.getParameter("major");
		String clas=request.getParameter("class");
		Student student=new Student();
		student.setInstitute(institute);
		student.setNum(num);
		student.setMajor(major);
		student.setClas(clas);
		UserDao dao = new UserDao();
		String result="";
		if(dao.modifyStudent(student)) {
			result="学生信息修改成功！"; 
		}else {
			result="学生信息修改失败！"; 
		}
		request.setAttribute("result", result);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/modifySRes.jsp");
		rd.forward(request, response);
		} 
}
