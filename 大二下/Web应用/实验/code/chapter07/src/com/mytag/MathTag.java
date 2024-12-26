package com.mytag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class MathTag extends SimpleTagSupport
implements DynamicAttributes{
double num = 0; 
String output = "";
public void setNum(double num){
this.num = num;
}
public void setDynamicAttribute(String uri, String localName,
Object value ) throws JspException{
double val = Double.parseDouble((String)value);
if (localName == "min"){
output = output + "<tr><td> "+num+"与"+val+"的最小值" + 
"</td><td>" + Math.min(num, val) + "</td></tr>";
} else if (localName == "max"){
output = output + "<tr><td> "+num+"与"+val+"的最大值" +
"</td><td>" + Math.max(num, val) + "</td></tr>";
} else if (localName == "pow"){
output = output + "<tr><td>"+num+" 的 "+val+
" 次方"+"</td><td>"+Math.pow(num, val)+"</td></tr>";
}
}
public void doTag() throws JspException, IOException{
getJspContext().getOut().print(output);
}
}

