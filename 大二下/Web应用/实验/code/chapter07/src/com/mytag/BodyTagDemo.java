package com.mytag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class BodyTagDemo extends SimpleTagSupport{
   public void doTag() throws JspException, IOException{
      JspWriter out = getJspContext().getOut();
      out.print("<p style=\"color:red\">********前</p>");
      // 获得标签体内容并发送到JSP显示
      getJspBody().invoke(null);
      out.print("<p style=\"color:blue\">#######后</p>");
   }
}
