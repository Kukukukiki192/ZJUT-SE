package com.demo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import com.model.Book;

@WebServlet("/BooksServlet")
public class BooksServlet extends HttpServlet {
    @Override
public void doGet(HttpServletRequest request, 
HttpServletResponse response) 
throws ServletException, IOException {
       List<Book> books = new ArrayList<Book>();
       Book book1 = new Book("978-7-302-23059-5","Java语言程序设计",45.00);
       Book book2 = new Book("978-7-302-21540-0","Java Web编程技术",39.00);
       Book book3 = new Book("978-7-302-24130-0","C #入门经典",99.80);
       books.add(book1);
       books.add(book2);
       books.add(book3);
       request.setAttribute("books", books);
       RequestDispatcher rd = request.getRequestDispatcher("/books.jsp");
       rd.forward(request, response);
  	}
}
