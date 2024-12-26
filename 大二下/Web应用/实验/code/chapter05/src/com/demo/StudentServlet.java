package com.demo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.*;
import java.util.*;
import com.model.Student;

@WebServlet(name = "addStudentServlet", urlPatterns = { "/addStudent.do" })
public class StudentServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;
 protected void doGet(HttpServletRequest request, 
         HttpServletResponse response) 
         throws ServletException, IOException  {
	       doPost(request,response);
	   }
  protected void doPost(HttpServletRequest request, 
                     HttpServletResponse response) 
                 throws ServletException, IOException {
	  try{   
	  String action = request.getParameter("action");
	     if(action!=null&&action.equals("addStudent")){
	         addStudent(request,response);
	     }else if(action.equals("remove")){
	         removeStudent(request,response);
	     }else{
	         listStudent(request,response);
	     }
	   }catch(Exception e){
		  
	   }
     }
     // 添加学生方法
     public void addStudent(HttpServletRequest request, 
                          HttpServletResponse response) 
              throws ServletException, IOException,DaoException  {
	     String no=  request.getParameter("sno");
	     String name =new String(
           request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
	       int age = Integer.parseInt(request.getParameter("age"));
	       String major = new String(
request.getParameter("major").getBytes("iso-8859-1"),"utf-8");
	    Student s = new Student();
	    s.setSno(no);
	    s.setSname(name);
	    s.setSage(age);
	    s.setMajor(major);
	    
	    StudentDao dao = new StudentDaoImpl();
	    boolean success= dao.addStudent(s);
	    if(success){
	        String message = "插入记录成功";
	        request.setAttribute("msg", message);
		    listStudent(request,response);
	    }else{
	    	RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
	    	rd.forward(request, response);
	    }
	  }
	  // 显示学生信息
public void listStudent(HttpServletRequest request, 
                  HttpServletResponse response) 
              throws ServletException, IOException,DaoException {
    StudentDao dao = new StudentDaoImpl();
	    List<Student> list= dao.listStudent();
    request.setAttribute("studentList", list);
    RequestDispatcher rd = request.getRequestDispatcher("addStudent.jsp");
    	rd.forward(request, response);
	  }
	
    public void removeStudent(HttpServletRequest request, 
              HttpServletResponse response) 
                throws ServletException, IOException,DaoException {
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDao dao = new StudentDaoImpl();
		int success=dao.removeStudent(id);
		if(success>0){
			listStudent(request,response);
		}
	}
}

