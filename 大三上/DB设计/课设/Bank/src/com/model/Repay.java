package com.model;

import java.sql.Timestamp;

public class Repay {
	public String 	U_id,
					A_id,
					L_id,
					R_money;
	public Timestamp R_time;
	
	public Repay() {
		super();
	}
	public Repay(String u_id, String a_id, String l_id, String r_money, Timestamp r_time) {
		super();
		U_id = u_id;
		A_id = a_id;
		L_id = l_id;
		R_money = r_money;
		R_time = r_time;
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
	public String getL_id() {
		return L_id;
	}
	public void setL_id(String l_id) {
		L_id = l_id;
	}
	public String getR_money() {
		return R_money;
	}
	public void setR_money(String r_money) {
		R_money = r_money;
	}
	public Timestamp getR_time() {
		return R_time;
	}
	public void setR_time(Timestamp r_time) {
		R_time = r_time;
	}	
}
