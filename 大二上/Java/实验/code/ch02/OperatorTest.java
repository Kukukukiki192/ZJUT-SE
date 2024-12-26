package cn.edu.zjut.java.ch02;

public class OperatorTest {

	public static void main(String[] args) {
		int i = 5;

		boolean j = false && (i++>5); // 执行完这句后i的值应该多少?
		System.out.println(i); // 输出变量i的值 为5，why?

		
		boolean k = false & (i++>5);
		System.out.println(k); // 将会发现输出的值为6，why?
		System.out.println(i); // 将会发现输出的值为6，why?

		
		int n = 8;
		int fourthBitFromRight = (n & (1 << 3)) >> 3;
		System.out.println(fourthBitFromRight);

	}

}
