package model;
//学号或工号、密码、姓名和用户类型
public class UserBean {
	 private String Num;
	 private String Psw;
	 private String Name;
	 private String Type;
	
	public UserBean() {
		super();
	}
	public UserBean(String num, String psw, String name, String type) {
		super();
		Num = num;
		Psw = psw;
		Name = name;
		Type = type;
	}
	public String getNum() {
		return Num;
	}
	public String getName() {
		return Name;
	}
	public String getType() {
		return Type;
	}
}
