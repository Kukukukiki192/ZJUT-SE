package com.model;

import java.sql.Timestamp;

public class Out {
	public String 	U_id,
					A_id,
					O_money;
	public Timestamp O_time;

	public Out() {
		super();
	}

	public Out(String u_id, String a_id, String o_money, Timestamp o_time) {
		super();
		U_id = u_id;
		A_id = a_id;
		O_money = o_money;
		O_time = o_time;
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

	public String getO_money() {
		return O_money;
	}

	public void setO_money(String o_money) {
		O_money = o_money;
	}
	
	public Timestamp getO_time() {
		return O_time;
	}
	
	public void setO_time(Timestamp o_time) {
		O_time = o_time;
	}
	
}
