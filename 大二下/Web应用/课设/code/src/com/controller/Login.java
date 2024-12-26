package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String type = request.getParameter("type");
		System.out.println(type);//测试	
        UserDao dao = new UserDao();
        String result = null;
		if(type.equals("学生")) { 
			request.setAttribute("type",1);
			String name = request.getParameter("name");		
			String num1 = request.getParameter("num1");
			String password2 = request.getParameter("password2");
			System.out.println(name+num1+" "+password2);//测试
	        Student student=dao.findSByName_Num_Psw(name,num1,password2);	        
			if(student==null||student.getNum()==null) { 
				result="登录失败！"; 
				System.out.println(student.getName()+student.getNum());//测试
				request.setAttribute("result", result);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
			else { 
				request.setAttribute("student", student);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index1.jsp");
				rd.forward(request, response);
			}
		}else {
			request.setAttribute("type",2);
			String character = request.getParameter("character");			
			System.out.println(character);//测试			
			Teacher teacher=new Teacher();
			if(character.equals("普通教师")) {
				String name = request.getParameter("name");	
				String num2 = request.getParameter("num2");
				String password2 = request.getParameter("password2");
				System.out.println(name+num2+" "+password2);//测试				
				teacher=dao.findTByName_Num_Psw(name,num2,password2);
				if(teacher==null||teacher.getNum()==null) { 
					System.out.println(teacher.getName()+teacher.getNum());//测试
					result="登录失败！"; 
					request.setAttribute("result", result);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}else { 				
					request.setAttribute("teacher", teacher);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/index1.jsp");
					rd.forward(request, response);
				}
			}else {
				String num2 = request.getParameter("num2");
				String password1 = request.getParameter("password1");
				System.out.println(num2+" "+password1);//测试
				teacher=dao.findTByNum_Psw(num2,password1);
				if(teacher==null||teacher.getNum()==null) { 
					System.out.println(teacher.getName()+teacher.getNum());//测试
					result="登录失败！"; 
					request.setAttribute("result", result);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}else { 
					request.setAttribute("teacher", teacher);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/index3.jsp");
					rd.forward(request, response);
				}
			}
			
		}
	}
	
}
