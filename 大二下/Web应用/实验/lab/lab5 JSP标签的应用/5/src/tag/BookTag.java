package tag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import model.Book;

public class BookTag extends SimpleTagSupport{
	private String search = null; 
	public void setSearch(String search){
		this.search = search;
	}	
	public void doTag() throws JspException, IOException{
		String output="";
		Book book;
		//读取图书信息
		BufferedReader bw=new BufferedReader(new FileReader("D:/Web应用/5/WebContent/WEB-INF/book.txt"));//要填绝对路径
		String s="";
		int flag=0;
		while((s=bw.readLine())!=null) {
			if(s.indexOf(search)>=0) {
				flag=1;
				break;	      
			}
		}bw.close();
	  	if(flag==0) {
	  		output="检索失败！";
	  	}else {
	  		String[] sArr=s.split("，");
			double price=Double.parseDouble(sArr[5]);
		    book=new Book(sArr[0],sArr[1],sArr[2],sArr[3],sArr[4],price);
	  		
	  	output="<table><tr style=\"background:#ababff\">"+
	  			"<th width=\"20%\">书名</th><th>作者</th><th width=\"20%\">出版社</th>"+
	  			"<th>出版时间</th><th width=\"20%\">ISBN号</th><th>价格</th></tr>"+
	  			"<tr style=\"background:#eeeeff\">" + 
	  			"<td>"+book.getTitle()+"</td>" + 
	  			"<td>"+book.getAuthor()+"</td>" + 
	  			"<td>"+book.getPublisher()+"</td>" + 
	  			"<td>"+book.getDate()+"</td>" + 
	  			"<td>"+book.getIsbn()+"</td>" + 
	  			"<td>"+book.getPrice()+"</td></tr></table>";
	  	}
	  	getJspContext().setAttribute("info",output);
	  	getJspBody().invoke(null);
	}
}
