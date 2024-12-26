package com.entity;
public class Member{
   private long id;                 // 会员标识
   private String name;             // 会员名
   private String password;          // 会员口令
   private String address;            // 会员地址
   private String email;              // 会员Email
   private int level;                 // 会员级别
   public Member() {}
   
   	public Member(String name, String password, String address, String email,
		int level) {
	super();
	this.name = name;
	this.password = password;
	this.address = address;
	this.email = email;
	this.level = level;
}

	// 这里省略各属性的setter方法和getter方法
public long getId(){
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public String toString(){
	return "会员ID="+getId()+"\n"
           +"会员姓名="+getName()+"\n"
           +"会员口令="+getPassword()+"\n"
           +"会员地址="+getAddress();
}
}

