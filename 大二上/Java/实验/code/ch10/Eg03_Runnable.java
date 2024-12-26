package cn.edu.zjut.java.ch10;

/**
 * 用 Runnable 的实例来创建一个线程对象
 */

public class Eg03_Runnable implements Runnable {
	private int ticket = 10;

	public void run() {
		while (this.ticket > 0) {
			try {
				// 为了演示，线程在这里睡眠一次
				Thread.sleep(100); // 基于共享资源实现的话，加入sleep就有可能导致出现出现负数；以及10,9,8.。。1不是按照顺序来的
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // 睡眠结束后，继续当前的票进行销售
			
			// 持续卖票，一直到剩余票数为0；
			System.out.println(Thread.currentThread().getName() + "卖票-->"
					+ (this.ticket--));
		}
	} // 建立三个售票窗口的线程类来模拟窗口售票

	public static void test01() {
		// 创建线程类
		Eg03_Runnable t1 = new Eg03_Runnable();
		Eg03_Runnable t2 = new Eg03_Runnable();
		Eg03_Runnable t3 = new Eg03_Runnable();

		// 创建线程
		Thread t1s = new Thread(t1);
		Thread t2s = new Thread(t2);
		Thread t3s = new Thread(t3);

		// 给线程命名
		t1s.setName("窗口1");
		t2s.setName("窗口2");
		t3s.setName("窗口3");

		// 线程运行
		t1s.start();
		t2s.start();
		t3s.start();
	}

	public static void test02() {
		// 创建线程类
		Eg03_Runnable t1 = new Eg03_Runnable();

		// 创建线程
		Thread t1s = new Thread(t1);
		Thread t2s = new Thread(t1);
		Thread t3s = new Thread(t1);

		// 给线程命名
		t1s.setName("窗口1");
		t2s.setName("窗口2");
		t3s.setName("窗口3");

		// 线程运行
		t1s.start();
		t2s.start();
		t3s.start();
	}

	static public void main(String args[]) {
		//test01();
		test02();
	}
}
