package cn.edu.zjut.java.ch04.InnerClass;

public class DefineInnerClassInFunction {
	private int size = 5;

	/** 方法makeInner()，返回一内部类对象 */
	public Object makeInner(final int finalLocalVar) {
		int LocalVar = 6;
		class Inner {
			public String toString() {
				return ("#<Inner size=" + size + "; finalLocalVar="
						+ finalLocalVar + ">");
			}
		}
		return new Inner(); // 方法makeInner()返回一内部类对象
	}

	public static void main(String[] args) {
		DefineInnerClassInFunction outer = new DefineInnerClassInFunction();
		Object obj = outer.makeInner(40);
		System.out.println("The object is " + obj.toString());
	}

}
