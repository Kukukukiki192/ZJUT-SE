package com.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Student;

@WebServlet("/importS.do")
public class ImportS extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out= response.getWriter();
		String Path = "D:/Web应用/7/WebContent/WEB-INF/S.txt";	
        BufferedReader br=new BufferedReader(new FileReader(Path));
		String s;
		StringBuffer s1 = new StringBuffer();
		while((s=br.readLine())!=null) {
			s1.append(s+"\t");
		}br.close();
		String str = new String(s1);	
		String[] strArr = str.split("\t");
		String result="";
		response.setContentType("text/html;charset=utf-8");
		UserDao dao = new UserDao();
		ArrayList<Student> sList = new ArrayList<Student>();
	    for(int i=0;i<strArr.length;i+=6) {	 
	    	//测试数据
	    	System.out.println(strArr[i]+" "+strArr[i+1]+" "+strArr[i+2]+" "+strArr[i+3]+" "+strArr[i+4]+" "+strArr[i+5]);   	
	    	Student student= new Student(strArr[i],strArr[i+1],strArr[i+2],"1111",strArr[i+3],strArr[i+4],strArr[i+5]);
	    	sList.add(student);
	    }
	    if(dao.addSlist(sList)) {
			result="批量导入学生用户成功！"; 
		}else {
			result="批量导入学生用户失败！"; 
		}		
	    request.setAttribute("result", result);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/importRes.jsp");
		rd.forward(request, response);	
//	    out.println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>批量导入结果</title></head><body>"+result+"<br><a href=\"control.jsp\">返回</a></body></html>");	  
	}
}
