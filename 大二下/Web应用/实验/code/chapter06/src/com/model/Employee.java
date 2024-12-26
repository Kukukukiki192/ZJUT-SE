package com.model;

public class Employee implements java.io.Serializable {
	private String empName;
	private String email;
	private String phone;
	private Address address;

	public Employee() {
	}

	public Employee(String empName, String email, String phone, Address address) {
		this.empName = empName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmpName() {
		return this.empName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}

	public Address getAddress() {
		return address;
	}
}
