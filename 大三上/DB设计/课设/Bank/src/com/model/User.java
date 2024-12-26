package com.model;

public class User {
	public String 	U_id,
					L_id,
					U_name,
					U_phone,
					U_city,
					U_psw;

	public User() {
		super();
	}

	public User(String u_id, String l_id, String u_name, String u_phone, String u_city, String u_psw) {
		super();
		U_id = u_id;
		L_id = l_id;
		U_name = u_name;
		U_phone = u_phone;
		U_city = u_city;
		U_psw = u_psw;
	}

	public String getU_id() {
		return U_id;
	}

	public void setU_id(String u_id) {
		U_id = u_id;
	}

	public String getL_id() {
		return L_id;
	}

	public void setL_id(String l_id) {
		L_id = l_id;
	}

	public String getU_name() {
		return U_name;
	}

	public void setU_name(String u_name) {
		U_name = u_name;
	}

	public String getU_phone() {
		return U_phone;
	}

	public void setU_phone(String u_phone) {
		U_phone = u_phone;
	}

	public String getU_city() {
		return U_city;
	}

	public void setU_city(String u_city) {
		U_city = u_city;
	}

	public String getU_psw() {
		return U_psw;
	}

	public void setU_psw(String u_psw) {
		U_psw = u_psw;
	}
	
}
