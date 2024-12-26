package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
throws ServletException, IOException {
		Student student= (Student)request.getAttribute("student");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();	
		out.println("<title>学生信息</title>");
		out.println("学号："+student.getSno()+"<br>");
		out.println("姓名："+new String(
student.getName().getBytes("iso-8859-1"),"UTF-8")+"<br>");
		out.println("<a href='input.jsp'>返回输入页面</a>");
	  }
}

