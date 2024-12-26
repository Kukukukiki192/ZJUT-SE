package com.mytag;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class LoopTag extends SimpleTagSupport{
   private int count = 0; 
   public void setCount(int count){
      this.count = count;
   }
   public void doTag() throws JspException,IOException{
	      JspWriter out = getJspContext().getOut();
      StringWriter sw = new StringWriter();
      getJspBody().invoke(sw);
      String text = sw.toString();
      for(int i = 1;i<=count;i++){
         out.print("<h"+i+">"+text+"</h"+i+">");	
      }
   }
}

