package cn.edu.zjut.java.ch04.InnerClass;

public class AccessInnerClassInOtherOUterClass {
	public static void main(String[] a) {
		AccessInnerClass out = new AccessInnerClass();
		AccessInnerClass.DefaultInner in = out.new DefaultInner();
		
		in.Area(10.0, 20.0);
		in.printArea();
	}
}
