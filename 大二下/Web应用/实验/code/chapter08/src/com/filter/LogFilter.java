package com.filter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "logFilter", urlPatterns = { "/*" })
public class LogFilter extends HttpFilter {	
	   private FilterConfig config;
	   // 实现初始化方法
	public void init(FilterConfig fConfig) throws ServletException {
			  this.config = fConfig;
		   }
	   // 实现过滤方法
public void doFilter(HttpServletRequest request, HttpServletResponse response,
        FilterChain chain) throws IOException, ServletException {
		   // 获得应用上下文对象
		   ServletContext context = config.getServletContext();
		   // 记录开始过滤时间
        long start = System.currentTimeMillis();
        System.out.println("请求的资源："+request.getRequestURI());
        System.out.println("用户地址："+request.getRemoteAddr());
        context.log("请求的资源："+request.getRequestURI());
        context.log("用户地址："+request.getRemoteAddr());
        // 请求转到下一资源或下一过滤器
	   chain.doFilter(request, response);
       // 记录返回到过滤器时间
		   long end = System.currentTimeMillis();
		   System.out.println("请求的总时间："+(end - start)+"毫秒");
        context.log("请求的总时间："+(end - start)+"毫秒");
     }
}
