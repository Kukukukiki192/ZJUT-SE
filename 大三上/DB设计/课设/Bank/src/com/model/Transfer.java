package com.model;

import java.sql.Timestamp;

public class Transfer {
	public String 	U_id,
					A_id,
					A_id1,
					T_money;
	public Timestamp T_time;

	public Transfer() {
		super();
	}

	public Transfer(String u_id, String a_id, String a_id1, String t_money, Timestamp t_time) {
		super();
		U_id = u_id;
		A_id = a_id;
		A_id1 = a_id1;
		T_money = t_money;
		T_time = t_time;
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

	public String getA_id1() {
		return A_id1;
	}

	public void setA_id1(String a_id1) {
		A_id1 = a_id1;
	}

	public String getT_money() {
		return T_money;
	}

	public void setT_money(String t_money) {
		T_money = t_money;
	}

	public Timestamp getT_time() {
		return T_time;
	}

	public void setT_time(Timestamp t_time) {
		T_time = t_time;
	}
}
