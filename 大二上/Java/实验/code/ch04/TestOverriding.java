package cn.edu.zjut.java.ch04;


class Base {
	public void method() {
		System.out.println("Base.method()");
	}
	public void play() {
		System.out.println("Base.play()");
	}
}

class Child extends Base {
	public void method()  {   //if we add throws exception
		System.out.println("Child.method()");
		
	}
//	/**
//	 * ������ֱ��������Ϊ�� �������ǵ�ԭ��(1): 
//	 *   ���෽�������ơ�����ǩ���ͷ������ͣ� �������丸��ķ��������ơ�����ǩ���ͷ�������һ��
//	 */
//	public int method() {
//		System.out.println("Child.method()");.;, M
//		return 0;
//	}
//
//	/**
//	 * ������ֱ��������Ϊ�� �������ǵ�ԭ��(2): 
//	 *   ���෽��������С���෽���ķ���Ȩ�� 
//	 *   Cannot reduce the visibility of the inherited method from Base
//	 */
//	protected void method() {
//		System.out.println("Child.method()");
//	}

	public int method(int a) {
		System.out.println("Child.method(int a)");
		return 0;
	}
	public  void play() {
		System.out.println("Child.play()");
	}
}

public class TestOverriding {

	public static void main(String args[]) {
		Child a = new Child();
		Base b = new Child();
		
		a.method();
		a.method(0);
		a.play();
		b.play();
	}
}
