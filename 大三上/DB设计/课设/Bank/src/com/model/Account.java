package com.model;

public class Account {
	public String 	A_id,
					B_name,
					A_money,//money
					A_psw,
					A_type,
					A1_interest,//decimal
					A2_overdraft;//money
	public int 		A_status;

	public Account() {
		super();
	}

	public Account(String a_id, String b_name, String a_psw, String a_type) {
		super();
		A_id = a_id;
		B_name = b_name;
		A_psw = a_psw;
		A_type = a_type;
	}

	public Account(String a_id, String b_name, String a_money, String a_psw, String a_type, String a1_interest,
			String a2_overdraft, int a_status) {
		super();
		A_id = a_id;
		B_name = b_name;
		A_money = a_money;
		A_psw = a_psw;
		A_type = a_type;
		A1_interest = a1_interest;
		A2_overdraft = a2_overdraft;
		A_status = a_status;
	}

	public String getA_id() {
		return A_id;
	}

	public void setA_id(String a_id) {
		A_id = a_id;
	}

	public String getB_name() {
		return B_name;
	}

	public void setB_name(String b_name) {
		B_name = b_name;
	}

	public String getA_money() {
		return A_money;
	}

	public void setA_money(String a_money) {
		A_money = a_money;
	}

	public String getA_psw() {
		return A_psw;
	}

	public void setA_psw(String a_psw) {
		A_psw = a_psw;
	}

	public String getA_type() {
		return A_type;
	}

	public void setA_type(String a_type) {
		A_type = a_type;
	}

	public String getA1_interest() {
		return A1_interest;
	}

	public void setA1_interest(String a1_interest) {
		A1_interest = a1_interest;
	}

	public String getA2_overdraft() {
		return A2_overdraft;
	}

	public void setA2_overdraft(String a2_overdraft) {
		A2_overdraft = a2_overdraft;
	}

	public int getA_status() {
		return A_status;
	}

	public void setA_status(int a_status) {
		A_status = a_status;
	}

}
