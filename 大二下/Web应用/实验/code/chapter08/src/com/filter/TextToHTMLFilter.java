package com.filter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST },
		   filterName = "TextToHTML", urlPatterns = {"*.txt"})
public class TextToHTMLFilter extends HttpFilter {
	private FilterConfig filterConfig;
	public void init(FilterConfig filterConfig){
	   this.filterConfig = filterConfig;
	}
	public void doFilter(HttpServletRequest request,HttpServletResponse response,
	           FilterChain filterChain) throws ServletException, IOException{
	   NonCachingRequestWrapper ncrw
	           = new NonCachingRequestWrapper( request );
	   TextResponseWrapper trw = new TextResponseWrapper(response);
	   //将包装后的请求和响应对象传到下一组件
	   filterChain.doFilter(ncrw, trw);
	   String top = "<html><head><title>销售报表</title></head>"
+ "<body background=\"textReport.gif\"><pre>";
	   String bottom = "</pre></body></html>";
	   //将文本数据嵌入到页面的<pre>标签中
	   StringBuilder htmlFile = new StringBuilder(top);
	   String textFile = new String(trw.toByteArray());
	   htmlFile.append(textFile);
	   htmlFile.append("<br>"+bottom);
	   //设置请求的字符编码和响应的内容类型
	   request.setCharacterEncoding("UTF-8");
	   response.setContentType("text/html;charset=UTF-8");
	   //设置内容类型的长度
	   response.setContentLength(htmlFile.length());
	   //将新数据用实际的PrintWriter输出
	   PrintWriter out = response.getWriter();
	   out.println(htmlFile.toString());
	}
}

