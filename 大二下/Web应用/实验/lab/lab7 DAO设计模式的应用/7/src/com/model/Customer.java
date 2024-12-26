package com.model;
import java.io.Serializable;
public class Customer implements Serializable{
   private String cust_id;
   private String cname;
   private String email;
   private double balance;
   public String getCust_id() {
	     return cust_id;
   }
   public void setCust_id(String cust_id) {
	     this.cust_id = cust_id;
   }
   public String getCname() {
	     return cname;
   }
   public void setCname(String cname) {
	     this.cname = cname;
   }
   public String getEmail() {
	     return email;
   }
   public void setEmail(String email) {
	     this.email = email; 
   }
   public double getBalance() {
	     return balance;
   }
   public void setBalance(double balance) {
	     this.balance = balance;
   }  
}

