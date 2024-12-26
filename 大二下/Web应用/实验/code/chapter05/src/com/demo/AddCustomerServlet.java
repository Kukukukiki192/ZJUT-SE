package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.Customer;
import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addCustomer.do")
public class AddCustomerServlet extends HttpServlet{
   public void doPost(HttpServletRequest request,
                           HttpServletResponse response)
                       throws ServletException,IOException{
      CustomerDao dao = new CustomerDaoImpl();
      System.out.println(dao);
      Customer customer = new Customer();
      String message = "";
      try{
        customer.setId(Integer.parseInt(request.getParameter("id")));
        // 将传递来的字符串重新使用utf-8编码，以免产生乱码
        customer.setName(new String(request.getParameter("cname")
                .getBytes("iso-8859-1"),"UTF-8"));
        customer.setEmail(new String(request.getParameter("email")
             .getBytes("iso-8859-1"),"UTF-8")); 
        customer.setBalance(
              Double.parseDouble(request.getParameter("balance")));
        boolean success = dao.addCustomer(customer);
        
        if(success){
             message = "<li>成功插入一条记录！</li>";
        }else{ 
             message = "<li>插入记录错误！</li>";
         }
      }catch(Exception e){
          System.out.println(e);
    	  message = "<li>插入记录错误！</li>" + e;
      }
      request.setAttribute("result", message);
      RequestDispatcher rd = 
      getServletContext().getRequestDispatcher("/addCustomer.jsp");
      rd.forward (request,response);
    }
}

