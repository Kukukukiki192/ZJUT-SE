package cn.edu.zjut.java.ch04;




abstract class GeometryObject {
	abstract protected double getArea();

	abstract protected void draw();
}

class Rectangle extends GeometryObject {
	float width, length;

	Rectangle(float w, float l) {
		width = w;
		length = l;
	}

	public double getArea() {
		return width * length;
	}

	public void draw() { // ���븲�Ǹ����abstract����
	}
}

class Circle extends GeometryObject {
	float radius;

	Circle(float radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public void draw() { // ���븲�Ǹ����abstract����
	}
}

public class GeometryObjectDemo {
	public static void main(String args[]) {
		GeometryObject r = new Rectangle(6, 12);
		System.out.println("The area of Rectangle: " + r.getArea());
		
		GeometryObject s = new Circle(5);
		System.out.println("The area of Circle: " + s.getArea());
	}
}
