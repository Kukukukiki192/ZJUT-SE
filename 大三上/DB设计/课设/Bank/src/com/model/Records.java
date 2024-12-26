package com.model;

import java.sql.Timestamp;

public class Records {
	public String U_id, A_id, Type, Money;
	public Timestamp Time;
	
	public Records() {
		super();
	}
	
	public Records(String u_id, String a_id, String type, String money, Timestamp time) {
		super();
		U_id = u_id;
		A_id = a_id;
		Type = type;
		Money = money;
		Time = time;
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
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getMoney() {
		return Money;
	}
	public void setMoney(String money) {
		Money = money;
	}
	public Timestamp getTime() {
		return Time;
	}
	public void setTime(Timestamp time) {
		Time = time;
	}

	
}
