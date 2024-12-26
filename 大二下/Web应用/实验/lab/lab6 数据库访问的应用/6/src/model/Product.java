package model;
import java.io.Serializable;

public class Product implements Serializable{
	private String prod_id;
	private String pname;
	private double price;
	private int stock;
	public Product() { }
	public Product(String prod_id, String pname, 
	double price, int stock) {
	    this.prod_id = prod_id;
		this.pname = pname;
		this.price = price;
		this.stock = stock;
	}
	public String getProd_id() {
		      return prod_id;
	}
	public void setProd_id(String prod_id) {
		      this.prod_id = prod_id;
	}
	public String getPname() {
		      return pname;
	}
	public void setPname(String pname) {
		      this.pname = pname;
	}
	public double getPrice() {
		      return price;
	}
	public void setPrice(double price) {
		      this.price = price;
	}
	public int getStock() {
		      return stock;
	}
	public void setStock(int stock) {
		      this.stock = stock;
	}
 }

