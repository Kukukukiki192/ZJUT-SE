package com.model;

import java.sql.Timestamp;

public class In {
	public String 	U_id,
					A_id,
					I_money;
	public Timestamp I_time;

	public In() {
		super();
	}

	public In(String u_id, String a_id, String i_money, Timestamp i_time) {
		super();
		U_id = u_id;
		A_id = a_id;
		I_money = i_money;
		I_time = i_time;
	}

	public String getU_id() {
		return U_id;
	}

	public void setU_id(String u_id) {
		U_id = u_id;
	}
	
	public String getA_id() {
		return A_id;
	}

	public void setA_id(String a_id) {
		A_id = a_id;
	}

	public String getI_money() {
		return I_money;
	}

	public void setI_money(String i_money) {
		I_money = i_money;
	}

	public Timestamp getI_time() {
		return I_time;
	}

	public void setI_time(Timestamp i_time) {
		I_time = i_time;
	}
	
}
