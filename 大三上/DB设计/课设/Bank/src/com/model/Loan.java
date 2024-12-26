package com.model;

import java.sql.Date;

public class Loan {
	public int 		L_id;
	public String 	U_id,
					U_name,
					A_id,
					L_money,
					B_name;
	public Date		L_date;
	
	
	public Loan() {
		super();
	}
	
	public Loan(int l_id, String u_id, String u_name, String a_id, String l_money, String b_name, Date l_date) {
		super();
		L_id = l_id;
		U_id = u_id;
		U_name = u_name;
		A_id = a_id;
		L_money = l_money;
		B_name = b_name;
		L_date = l_date;
	}
	
	public int getL_id() {
		return L_id;
	}
	public void setL_id(int l_id) {
		L_id = l_id;
	}
	public String getU_id() {
		return U_id;
	}
	public void setU_id(String u_id) {
		U_id = u_id;
	}
	public String getU_name() {
		return U_name;
	}
	public void setU_name(String u_name) {
		U_name = u_name;
	}
	public String getA_id() {
		return A_id;
	}
	public void setA_id(String a_id) {
		A_id = a_id;
	}
	public String getL_money() {
		return L_money;
	}
	public void setL_money(String l_money) {
		L_money = l_money;
	}
	public String getB_name() {
		return B_name;
	}
	public void setB_name(String b_name) {
		B_name = b_name;
	}
	public Date getL_date() {
		return L_date;
	}
	public void setL_date(Date l_date) {
		L_date = l_date;
	}
	
}
