package bank.com.model;

public class Customer {
	 private final String email,password,custName,phone;
	 
	public Customer(String email, String password, String custName, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.custName = custName;
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getCustName() {
		return custName;
	}
	public String getPhone() {
		return phone;
	}
	public boolean equals(String email, String pwd) {
		return getEmail().equals(email) && getPassword().equals(pwd); 
	}
}
