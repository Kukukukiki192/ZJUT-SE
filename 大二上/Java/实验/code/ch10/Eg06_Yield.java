package cn.edu.zjut.java.ch10;

class Thread1 extends Thread {
	int i = 0;

	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) { // 线程运行到3的倍数次时就让步一次
				System.out.println(Thread.currentThread().getName() + "第" + i
						+ "次运行，让步");
				Thread.yield();// 线程让步
			} else {
				System.out.println(Thread.currentThread().getName() + "第" + i
						+ "次运行");
			}
		}
	}
}

public class Eg06_Yield {
	static public void main(String args[]) {
		Thread1 t1 = new Thread1();// 创建三个线程对象
		t1.setName("第一个线程");// 线程命名
		Thread1 t2 = new Thread1();
		t2.setName("第二个线程");
		Thread1 t3 = new Thread1();
		t3.setName("第三个线程");
		t1.start();// 启动线程
		t2.start();
		t3.start();
	}
}
