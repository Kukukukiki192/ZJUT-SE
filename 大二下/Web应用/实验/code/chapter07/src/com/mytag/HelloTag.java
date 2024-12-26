package com.mytag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.time.LocalTime;

public class HelloTag implements SimpleTag{
	    JspContext jspContext = null;
	    JspTag parent = null;
	    public void setJspContext(JspContext jspContext){
		   this.jspContext = jspContext;
	    }
	    public void setParent(JspTag parent){
		   this.parent = parent;
	    }
	    public void setJspBody(JspFragment jspBody){
	    }
	    public JspTag getParent(){
		    return parent;
	    }
    public void doTag() throws JspException, IOException{
        JspWriter out = jspContext.getOut();
       out.print("<p style=\"color:blue\">这是简单标签</p>");
       out.print("现在时间是："+ LocalTime.now());
    }
}

