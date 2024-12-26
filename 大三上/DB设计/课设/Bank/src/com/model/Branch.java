package com.model;

public class Branch {
	public String 	B_name,
					B_city,
					B_money;

	public Branch() {
		super();
	}

	public Branch(String b_name, String b_city, String b_money) {
		super();
		B_name = b_name;
		B_city = b_city;
		B_money = b_money;
	}

	public String getB_name() {
		return B_name;
	}

	public void setB_name(String b_name) {
		B_name = b_name;
	}

	public String getB_city() {
		return B_city;
	}

	public void setB_city(String b_city) {
		B_city = b_city;
	}

	public String getB_money() {
		return B_money;
	}

	public void setB_money(String b_money) {
		B_money = b_money;
	}
	
}
