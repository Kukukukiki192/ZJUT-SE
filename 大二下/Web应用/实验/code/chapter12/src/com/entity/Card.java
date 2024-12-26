package com.entity;

public class Card {
	private Integer id;
	private String cardNo;
	private String major;
	private double balance;
	private Student student;   // 一个Student类型的属性
	public Card(){}
	public Card(String cardNo, String major, double balance) {
		this.cardNo = cardNo;
		this.major = major;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
