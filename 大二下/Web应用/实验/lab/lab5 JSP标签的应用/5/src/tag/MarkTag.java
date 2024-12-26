package tag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class MarkTag extends SimpleTagSupport{
	private String search = null; 
	public void setSearch(String search){
		this.search = search;
	}
	public void doTag() throws JspException, IOException{
//		JspWriter out = getJspContext().getOut();
		String output="";
		//读取文章
		BufferedReader bw=new BufferedReader(new FileReader("D:/Web应用/5/WebContent/WEB-INF/article.txt"));//要填绝对路径
		String s;
		StringBuffer s1 = new StringBuffer();
		while((s=bw.readLine())!=null) {
			s1.append(s);
		}bw.close();
		String text = new String(s1);	
//	   	StringWriter sw = new StringWriter();
//	 	getJspBody().invoke(sw);//读取标签体
//	  	String text = sw.toString();
	    
	  	int len = search.length();
	 	int oldIndex=0, newIndex=0,flag=0;
	  	while((newIndex = text.indexOf(search,oldIndex))>=0){
	  		if (newIndex<oldIndex){
	  			break;
	    	}flag=1;
	  		output+=text.substring(oldIndex,newIndex)+"<b><font color='red'>"+search+"</font></b>";
	  		oldIndex = newIndex + len;
	 	}
	  	if(flag==0) {
	  		output="关键字不存在！";
	  	}else {
	  		output+=text.substring(oldIndex);
	  	}
	  	getJspContext().setAttribute("text",output);
	  	getJspBody().invoke(null);
	}
}
