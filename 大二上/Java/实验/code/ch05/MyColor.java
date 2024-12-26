package cn.edu.zjut.java.ch05;

public enum MyColor{
	
	RED(255, 0, 0), BLUE(0, 0, 255);
	
	private int redValue;
	private int greenValue;
	private int blueValue; 
	private MyColor(int rv , int gv, int bv){
		redValue = rv;
		greenValue = gv;
		blueValue = bv;
	}
	
	public String toString(){
		return super.toString() + redValue + "," + greenValue + "," + blueValue;
	}
	
	
	
	
}