package cn.edu.zjut.java.ch04.interfacedemo;

interface HasArea{
	public double getArea();
}
abstract class GeometryObject { 
	 protected void draw() { int a= 1;};
}
class Rectangle extends GeometryObject implements HasArea{
	float width, length;

	Rectangle(float w, float l) {
		width = w;
		length = l;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

class Circle extends GeometryObject implements HasArea{
	float radius;

	Circle(float radius) {
		this.radius = radius;
	}
 

	public void draw() { // ���븲�Ǹ����abstract����
	}


	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
}

public class GeometryObjectDemoWithInterface {
	public static void main(String args[]) {
		HasArea r = new Rectangle(6, 12);
		System.out.println("The area of Rectangle: " + r.getArea());
		
		HasArea s = new Circle(5);
		System.out.println("The area of Circle: " + s.getArea());
		
		String a = "";
	}
}
