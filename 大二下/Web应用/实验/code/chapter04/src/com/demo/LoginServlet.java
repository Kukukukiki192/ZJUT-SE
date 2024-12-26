package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, 
        HttpServletResponse response) 
                throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (userName != null && userName.equals("member") 
                && password != null && password.equals("member01")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn", Boolean.TRUE);
            response.sendRedirect("download");
            return;
        } else {
            RequestDispatcher dispatcher = 
              request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}

