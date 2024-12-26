package com.demo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;

@WebServlet(urlPatterns="/asyncDemo",asyncSupported=true)
public class AsyncDemoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response) 
                      throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       out.println("<html><head><title>异步调用示例</title></head>");
       out.println("<body>");
       out.println("进入Servlet的时间："+ LocalTime.now()+".<br>");
       out.flush();
       AsyncContext actx = request.startAsync();
       actx.setTimeout(30*1000);  // 设置异步调用的超时时长30秒
       // 启动异步调用的线程
       actx.start(new Executor(actx)); 
       out.println("结束Servlet的时间："+ LocalTime.now()+".</br>");
       out.flush();
	}
}

