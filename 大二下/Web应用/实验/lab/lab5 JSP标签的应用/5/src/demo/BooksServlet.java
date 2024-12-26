package demo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import model.Book;

@WebServlet("/BooksServlet")
public class BooksServlet extends HttpServlet {    
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Book> books = new ArrayList<Book>();
       BufferedReader bw=new BufferedReader(new FileReader("D:/Web应用/5/WebContent/WEB-INF/book.txt"));
       String s1=""; 
       StringBuffer s=new StringBuffer();
       while((s1=bw.readLine())!=null) {
    	   s.append(s1+"，"); 
       }bw.close();
       String str=new String(s);
       String[] sArr=str.split("，");
       for(int i=0;i<sArr.length;i+=6) {
    	   double price=Double.parseDouble(sArr[i+5]);
    	   books.add(new Book(sArr[i],sArr[i+1],sArr[i+2],sArr[i+3],sArr[i+4],price));
       }
       request.setAttribute("books",books);//(books.get(i)获得指定索引的元素)
       RequestDispatcher rd = request.getRequestDispatcher("/books.jsp");
       rd.forward(request, response);
  	}
}
