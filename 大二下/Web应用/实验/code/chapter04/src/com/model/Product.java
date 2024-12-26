package com.model;
import java.io.Serializable;
public class Product implements Serializable{
	 private int id;                  // 商品编号
     private String pname;           // 商品名称
     private double price;            // 商品价格
     private int stock;               // 商品库存量
     private String type;             // 商品类别
     // 构造方法
     public Product(){}
     public Product(int id, String pname, double price,
                     int stock, String type) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.stock = stock;
        this.type = type;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
        
}
