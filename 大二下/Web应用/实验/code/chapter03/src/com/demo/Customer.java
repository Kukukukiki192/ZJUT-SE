package com.demo;
public class Customer{
// 属性声明
private String custName;
private String email;
private String phone;
// 构造方法的定义
public Customer(){}
public Customer(String custName, String email, String phone){
       this.custName = custName;
       this.email = email;
       this.phone = phone;
}
// getter方法
public String getCustName(){ return this.custName; }
public String getEmail(){ return this.email; }
public String getPhone(){ return this.phone; }
// setter方法
public void setCustName(String custName){ this.custName = custName; }
public void setEmail(String email){ this.email = email; }
public void setPhone(String phone){ this.phone = phone; }
}

