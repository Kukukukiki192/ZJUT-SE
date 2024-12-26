package cn.edu.zjut.java.ch04.InnerClass;

public class AccessInnerClass {
	/**
	 * 静态内部类
	 */
	static class StaticInner {
		double s;
		final static double PI = 3.1415;

		double Area(double r) {
			return s = PI * r * r;
		}

		void printArea() {
			System.out.println("StaticInner.area = " + s);
		}
	}

	/**
	 * 非静态内部类
	 */
	class DefaultInner {
		double s;
		final static String FORMAT = "[0-9][0-5]";

		double Area(double w, double h) {
			return s = w * h;
		}

		void printArea() {
			System.out.println("DefaultInner.area = " + s);
		}
	}

	public static void main(String args[]) {
		/**
		 * 创建【静态实名内部类】，及访问其内部成员
		 */
		// 创建【静态实名内部类】
		AccessInnerClass.StaticInner c1 = new AccessInnerClass.StaticInner();

		// 访问【静态实名内部类】的【静态成员】
		System.out.println(AccessInnerClass.StaticInner.PI);

		// 访问静态实名内部类的非静态成员：
		c1.Area(10.0);
		c1.printArea();

		/**
		 * 创建【非静态实名内部类】，及访问其内部成员
		 */
		// 创建【非静态实名内部类】
		AccessInnerClass o = new AccessInnerClass();
		AccessInnerClass.DefaultInner c21 = o.new DefaultInner();
		AccessInnerClass.DefaultInner c22 = new AccessInnerClass().new DefaultInner();

		// 访问【非静态实名内部类】的【静态成员】
		System.out.println(AccessInnerClass.DefaultInner.FORMAT);

		// 访问【非静态实名内部类】的【非静态方法】
		c22.Area(10.0, 20.0);
		c22.printArea();
	}
}
