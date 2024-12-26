package com.Filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

//只有转发访问index.jsp时，该过滤器才会被执行
@WebFilter(filterName="FilterOne",urlPatterns="/admin/*",dispatcherTypes={DispatcherType.FORWARD})
//@WebFilter(filterName="FilterTwo",urlPatterns= {"/users/*","/*"})
//@WebFilter(filterName="FilterThree",urlPatterns="/admin/*")
public class FilterOne implements Filter {
	public void destroy() {
		//销毁时调用
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//过滤方法 主要是对request和response进行一些处理,然后交给下一个过滤器或Servlet处理
		System.out.println("这是过滤器FilterOne");
//		System.out.println("这是过滤器FilterTwo");
//		System.out.println("这是过滤器FilterThree");
		chain.doFilter(request, response);//交给下一个过滤器或servlet处理
	}
	public void init(FilterConfig fConfig) throws ServletException {
		//初始化方法  接收一个FilterConfig类型的参数 该参数是对Filter的一些配置
	}
}
