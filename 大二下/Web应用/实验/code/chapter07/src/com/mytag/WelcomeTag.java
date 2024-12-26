package com.mytag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class WelcomeTag extends SimpleTagSupport {
  private String user; 
  public void setUser(String user) {
    this.user = user; 
  }
  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
    try{
     if (user==null){
         out.print("欢迎光临！<br>");
     }else{
         out.print("欢迎您，"+user+"！<br>");
     }
    } catch(Exception e){
       throw new JspException("Error in WelcomeTag.doTag()");}
  }
}

