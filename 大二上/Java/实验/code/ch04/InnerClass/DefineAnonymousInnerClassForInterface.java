package cn.edu.zjut.java.ch04.InnerClass;

interface JInterface {
	int m_data = 5;
	public abstract void fun();
}

public class DefineAnonymousInnerClassForInterface {
	public static void main(String args[]) {
		JInterface b = new JInterface() {
			public void fun() {
				System.out.println("m_data = " + m_data);
			}
		}; // 父类型为类 JInterface 的匿名内部类结束
		
		b.fun();
	}
}
