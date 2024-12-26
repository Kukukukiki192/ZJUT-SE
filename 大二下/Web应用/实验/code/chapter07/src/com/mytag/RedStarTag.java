package com.mytag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class RedStarTag extends SimpleTagSupport {
   public void doTag() throws JspException, IOException{
       JspWriter out = getJspContext().getOut();
       out.print("<font color='#FF0000'>*</font>");
  }
}
