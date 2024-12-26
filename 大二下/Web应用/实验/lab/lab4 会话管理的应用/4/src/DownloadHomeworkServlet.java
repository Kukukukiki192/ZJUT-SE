//判断当前用户类型,若为教师,则运行下载;若为学生,则判断该文件是否与当前学生学号studentid匹配,不匹配则不允许下载

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;

@WebServlet("/downloadHomework.do")//不加'/'映射地址错误
public class DownloadHomeworkServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//判断session是否存在
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("user") == null) {
            RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");//未登录,则跳转至登录页面
            dispatcher.forward(request, response);
            return;  
        }
        UserBean c= (UserBean)session.getAttribute("user");
        String filename=request.getParameter("filename");
		session.setAttribute("filename", filename);
        if(c.getType().equals("学生")) {
        	if(c.getNum().equals(request.getParameter("studentid"))) {
        		response.sendRedirect("FileDownloadServlet");
        	}else {
        		response.setContentType("text/html;charset=utf-8");
        		PrintWriter out= response.getWriter();
        		out.println("<script language='JavaScript'>alert('您没有权限下载该作业');</script>");     		
        	}
        }else {
        	response.sendRedirect("FileDownloadServlet");
        }
              
		doGet(request, response);
	}
}