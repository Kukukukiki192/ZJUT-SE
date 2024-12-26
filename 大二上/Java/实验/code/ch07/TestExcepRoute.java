package cn.edu.zjut.java.ch07;

public class TestExcepRoute {
	public static void main(String[] args) {
		try {
			method();
		} catch (Exception e) {
			System.out.print('m');
		}
		System.out.println('n');
	}

	static void createException() {
		throw new ArrayIndexOutOfBoundsException();
	}

	static void method() {
		try {
			createException();
			System.out.print('a');
		} catch (ArithmeticException e) {

			System.out.print('b');
		} finally {
			System.out.print('c');
		}
		System.out.print('d');
	}

}
