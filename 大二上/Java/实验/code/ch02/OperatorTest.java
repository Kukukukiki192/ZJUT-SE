package cn.edu.zjut.java.ch02;

public class OperatorTest {

	public static void main(String[] args) {
		int i = 5;

		boolean j = false && (i++>5); // ִ��������i��ֵӦ�ö���?
		System.out.println(i); // �������i��ֵ Ϊ5��why?

		
		boolean k = false & (i++>5);
		System.out.println(k); // ���ᷢ�������ֵΪ6��why?
		System.out.println(i); // ���ᷢ�������ֵΪ6��why?

		
		int n = 8;
		int fourthBitFromRight = (n & (1 << 3)) >> 3;
		System.out.println(fourthBitFromRight);

	}

}
