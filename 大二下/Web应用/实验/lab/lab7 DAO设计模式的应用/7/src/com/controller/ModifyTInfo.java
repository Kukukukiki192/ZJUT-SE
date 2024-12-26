package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Teacher;

@WebServlet("/modifyTInfo.do")
public class ModifyTInfo extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num=request.getParameter("num");
		String institute=request.getParameter("institute");	
		Teacher teacher=new Teacher();
		teacher.setInstitute(institute);
		teacher.setNum(num);
		UserDao dao = new UserDao();
		String result="";
		if(dao.modifyTeacher(teacher)) {
			result="教师信息修改成功！"; 
		}else {
			result="教师信息修改失败！"; 
		}
		request.setAttribute("result", result);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/modifyTRes.jsp");
		rd.forward(request, response);
		} 
}
