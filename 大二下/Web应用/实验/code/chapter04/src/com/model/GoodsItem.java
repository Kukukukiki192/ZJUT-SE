package com.model;
import java.io.Serializable;
public class GoodsItem implements Serializable {
	 private Product product;    // 商品信息
     private int quantity;       // 商品数量
     
     public GoodsItem(Product product) {
         this.product = product;
         quantity = 1;
     }
     public GoodsItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
     }
     // 属性的getter方法和setter方法
     public Product getProduct() {
		return product;
	   }
     public void setProduct(Product product) {
		 this.product = product;
	 }
	   public int getQuantity() {
		return quantity;
     }
    public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

