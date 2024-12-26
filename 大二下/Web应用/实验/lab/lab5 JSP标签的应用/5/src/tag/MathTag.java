package tag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class MathTag extends SimpleTagSupport{
	double x=0; 
    public void setX(double x){
        this.x = x;
    }  
    public void doTag() throws JspException, IOException{
    	JspWriter out = getJspContext().getOut();
    	try{
    		if(x<0){
    			out.print("<tr><td>"+x+"</td><td>error</td><tr>");
    		}else{
    			out.print("<tr><td>"+x+"</td><td>"+Math.sqrt(x)+"</td><tr>");
    		}
    	}catch(Exception e){
    		throw new JspException("Error in MathTag.doTag()");
    	}
    }
}