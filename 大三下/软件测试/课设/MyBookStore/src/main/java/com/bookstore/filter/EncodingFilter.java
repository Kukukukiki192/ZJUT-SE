package com.bookstore.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(filterName = "/EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {
	//定义替换后的字符集，从过滤器的配置参数中读取
	private String characterEncoding;
	/**
	 * Default constructor.
	 */
	public EncodingFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("web.xml中该过滤器配置的encoding值为" + characterEncoding);
		 request.setCharacterEncoding(characterEncoding);
		 response.setContentType("text/html;charset="+characterEncoding);
		 chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 获取web.xml中filter配置的参数
		if( fConfig.getInitParameter("encoding")!=null) {
			characterEncoding = fConfig.getInitParameter("encoding");
		}else {
			characterEncoding ="UTF-8";
		}
		
		
		
	}

}
