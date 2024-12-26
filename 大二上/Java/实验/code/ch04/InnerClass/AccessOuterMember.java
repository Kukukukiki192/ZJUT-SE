package cn.edu.zjut.java.ch04.InnerClass;

public class AccessOuterMember {
	private int size;

	/**
	 * 【内部类】访问【外部类】的成员
	 */
	public class Inner1 {
		// 将外部类的成员变量size递增
		public void doStuff() {
			size++;
		}
	}
	
	/**
	 * 当内部类和外部类的命名冲突时，显式访问【外部类】和【内部类】的成员
	 */
	public class Inner2 {
		private int size;

		// 将外部类的成员变量size递增
		public void doStuff(int size) {
			size++; // 存取参数
			this.size++; // 存取内部类的成员变量
			AccessOuterMember.this.size++; // 存取其外包类AccessOuterMember的成员变量
			System.out.println("size in Inner1.doStuff(): " + size);
			System.out.println("size of the Inner1 class: " + this.size);
			System.out.println("size of the AccessOuterMember class: "
					+ AccessOuterMember.this.size);
		}
	}

	Inner1 c1 = new Inner1(); // 成员变量 c1 指向 Inner1 类的对象
	Inner2 c2 = new Inner2(); // 成员变量 c2 指向 Inner2 类的对象

	public void increaseSize() {
		c1.doStuff(); // 调用内部类Inner的方法
	}

	public static void main(String args[]) {
		/**
		 * 内部类成员访问外部类的成员
		 */
		AccessOuterMember o = new AccessOuterMember();
		
		for (int i = 0; i < 4; i++) {
			o.increaseSize();
			System.out.println("The value of size : " + o.size);
		}
		
		/**
		 * 当内部类和外部类的命名冲突时，显式访问【外部类】和【内部类】的成员
		 */
		System.out.println("==============================");
		o.c2.doStuff(0);
	}
}
