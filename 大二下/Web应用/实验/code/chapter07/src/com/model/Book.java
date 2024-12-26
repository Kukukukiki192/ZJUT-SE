package com.model;
public class Book{
   private String isbn;
   private String title;
   private double price;
   public Book(String isbn, String title, double price){
       this.isbn = isbn;
       this.title = title;
       this.price = price;
    }
   public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
   
// 这里省略了属性的setter方法和getter方法
}
