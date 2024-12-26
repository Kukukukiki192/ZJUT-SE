package com.model;

public class User{
    private Long id;
    private String username;
    private String password;
    private int age;
    private String email;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	// 这里省略了属性的getter方法和setter方法
    @Override
public String toString(){
    return "用户名: " + getUsername() +"口令: " + getPassword()
+ "年龄: " + getAge() +" Email:" + getEmail();
    }
}

