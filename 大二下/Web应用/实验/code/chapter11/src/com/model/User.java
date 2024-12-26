package com.model;

public class User {
	private String username;
	private String password;
	private int age;
	private String email;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, int age, String email) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
