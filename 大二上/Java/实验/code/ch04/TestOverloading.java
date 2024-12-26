package cn.edu.zjut.java.ch04;


public class TestOverloading {

	public void add(int a) {
		System.out.println("add(int a)");
	}
	
//	public int add(int a) {
//		System.out.println("add(int a)");
//		return 0;
//	}
	
	public void add(long a)  {
		System.out.println("add(long a)");
	}
	
	public void add(int a, int b)  {
		System.out.println("add(int a, int b)");
	}
	
	// 参数的顺序不同
//	public void add(int b, int a)  {
//		System.out.println("add(int a, int b)");
//	}
	
	public void add(float a)  {
		System.out.println("add(float a)");
	}
	
	public static void main(String[] args) {
		TestOverloading t = new TestOverloading();
		int a = 3;
		long b = 4;
		
		t.add(a);
		t.add(b);
	}

}
