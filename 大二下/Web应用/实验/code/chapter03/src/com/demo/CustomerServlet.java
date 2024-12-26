package com.demo;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
   public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
              throws java.io.IOException,ServletException {
    String name = request.getParameter("custName");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    Customer customer = new Customer(name,email,phone);

    HttpSession session = request.getSession();
    synchronized(session) {
        session.setAttribute("customer", customer);
    }
    RequestDispatcher rd = 
    	  request.getRequestDispatcher("/displayCustomer.jsp");
    rd.forward(request,response); 
  }
} 

