package model;

public class Book {
	String title;
	String author;
	String publisher;
	String date;
	String isbn;
	double price;
	public Book() {
		super();
	}
	public Book(String title, String author, String publisher, String date, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.date = date;
		this.isbn = isbn;
		this.price = price;
	}	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
