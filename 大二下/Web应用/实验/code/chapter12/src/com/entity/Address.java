package com.entity;

public class Address {
	   private String city;
	   private String street;
	   private String zipcode;
	   public Address(){}  // 默认构造方法
	   public Address(String city, String street, String zipcode) {
		  this.city = city;
		  this.street = street;
		  this.zipcode = zipcode;
	   }
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
