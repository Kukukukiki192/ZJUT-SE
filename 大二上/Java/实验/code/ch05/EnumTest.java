package cn.edu.zjut.java.ch05;

enum Color {
	RED(255, 0, 0), BLUE(0, 0, 255), BLACK(0, 0, 0), YELLOW(255, 255, 0), GREEN(0, 255, 0);

	// 构造枚举值，比如RED(255,0,0)  
	private Color(int rv, int gv, int bv) {
		this.redValue = rv;
		this.greenValue = gv;
		this.blueValue = bv;
	}

	private int redValue;// 自定义数据域，private为了封装

	private int greenValue;

	private int blueValue;

	public String toString() { // 覆盖了父类Enum的toString() 
		return super.toString() + "(" + redValue + "," + greenValue + "," + blueValue + ")";
	}
}

public class EnumTest {

	public static void callEnum(Color c){
		
		//do nothing;
	}
	
	public static void main(String[] args) {

		System.out.println(Color.RED);
		System.out.println(Color.RED.ordinal());

		callEnum(Color.RED);  
		//callEnum(0);  
		
		Color[] colors = Color.values();
		for(Color c : colors){
			System.out.print(c + ",");
		} 
		 
	}

}
