package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.Address;
import com.model.Employee;
import javax.servlet.annotation.WebServlet;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet{
   public void doGet(HttpServletRequest request, 
        HttpServletResponse response) 
                 throws ServletException,IOException{
      Address address = new Address("上海市", "科技路25号","201600");
      Employee employee = new Employee("张大海", 
    		   "hacker@163.com","8899123",address);
      request.setAttribute("employee", employee);
      Cookie cookie = new Cookie("userName","Hacker");
      response.addCookie(cookie);

      RequestDispatcher rd = 
                     request.getRequestDispatcher("/beanDemo.jsp");
       rd.forward(request, response);
}
}

