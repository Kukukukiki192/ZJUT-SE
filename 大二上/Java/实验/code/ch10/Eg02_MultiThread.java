package cn.edu.zjut.java.ch10;

public class Eg02_MultiThread extends Thread {
	int ticket = 10;

	// 重写Thread类的run()方法；
	public void run() {
		// 持续卖票，一直到剩余票数为0；
		while (this.ticket > 0) {
			System.out.println(this.getName() + "卖票-->" + (this.ticket--));
		}
	}

	static public void main(String args[]) {
		// 建立三个售票窗口的线程类来模拟窗口售票
		Eg02_MultiThread t1 = new Eg02_MultiThread();
		Eg02_MultiThread t2 = new Eg02_MultiThread();
		Eg02_MultiThread t3 = new Eg02_MultiThread();

		// 给线程命名
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");

		// 线程运行
		t1.start();
		t2.start();
		t3.start();
	}

}
