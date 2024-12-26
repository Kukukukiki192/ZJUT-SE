package com.mytag;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class MarkerTag extends SimpleTagSupport {
private String search = null; // search属性
public void setSearch(String search){
this.search = search;
}
public void doTag() throws JspException, IOException{
       JspWriter out = getJspContext().getOut();
       StringWriter sw = new StringWriter();
       getJspBody().invoke(sw);
       String text = sw.toString();
    
       int len = search.length();
       int oldIndex=0, newIndex=0;
       while((newIndex = text.indexOf(search,oldIndex))>=0){
          if (newIndex<oldIndex){
             break;
         }
       out.print(text.substring(oldIndex,newIndex));
       out.print("<a href=\"\" ><b><font color='blue' size='15'>"+search+"</font></b></a>");
       oldIndex = newIndex + len;
     }
     out.print(text.substring(oldIndex));
   }
}

