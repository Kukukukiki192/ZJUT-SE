package stu;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet(name = "StudentServlet", urlPatterns = { "StudentServlet" })
@WebServlet("StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Stuid = request.getParameter("Stuid");
		String Name = request.getParameter("Name");
		String Major = request.getParameter("Major");
		Student student=new Student(Stuid,Name,Major);
		HttpSession session=request.getSession();
		synchronized(session) {
			session.setAttribute("student",student);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/1/displayStudent.jsp");
		rd.forward(request, response);		
	}
}