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
import com.model.*;

@WebServlet("/SqueryScoreServlet")
public class SqueryScoreServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
//		int x = Integer.parseInt(request.getParameter("x"));
//		request.setAttribute("x", x);
		String result = null;
		UserDao dao = new UserDao();
//		if(x==1){
			ArrayList<Manager> sList =dao.SqueryScore11("S01");
			if(sList==null) {
				result="查询失败!"; //System.out.println("查询失败!");
				request.setAttribute("result", result);
			} else {//result="查询成功"; 
				request.setAttribute("sList", sList);		
			}			
//		} else {
//			ArrayList<Manager> cList =dao.AVGscore();
//			if(cList==null) {
//				result="查询失败!"; //System.out.println("查询失败!");
//				request.setAttribute("result", result);
//			} else {//result="查询成功"; 
//				request.setAttribute("cList", cList);		
//			}	
//		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/SqueryScore.jsp");
		rd.forward(request, response);	
	}
}
