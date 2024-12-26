package cn.edu.zjut.java.ch10;

/**
 * 两种方式实现同步： synchronized void methodA() { }
 * 
 * 使用同步块 synchronized(obj){ obj是被锁定的对象 要同步的语句 }
 */

public class Eg08_SynchronizedThread implements Runnable {
	// 一共有10张票
	private int ticket = 10;

	public void run() {
		while (true) { // 持续卖票，一直到剩余票数为0；
			synchronized (this) {  //TODO 删除这行试试看
				if (ticket > 0) {
					try {
						// 为了演示，线程在这里睡眠一次
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // 睡眠结束后，继续当前的票进行销售
					System.out.println(Thread.currentThread().getName()
							+ "卖票-->" + (this.ticket--));
				} else {
					break;
				}
			}
		}
	}
	
//	public void run(){ 
//		while(ticket>0) {//持续卖票，一直到剩余票数为0
//			sell();
//		}
//	}

	public synchronized void sell() {
		if (ticket > 0) {
			try {
				// 为了演示产生的问题，线程在这里睡眠一次
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 睡眠结束后，继续当前的票进行销售
			System.out.println(Thread.currentThread().getName() + "卖票-->"
					+ (this.ticket--));
		}
	}

	// 建立三个售票窗口的线程类来模拟窗口售票
	static public void main(String args[]) {
		Eg08_SynchronizedThread ru = new Eg08_SynchronizedThread();

		Thread t = new Thread(ru); // 新建线程
		t.setName("窗口1");// 线程命名
		Thread t1 = new Thread(ru);
		t1.setName("窗口2");
		Thread t2 = new Thread(ru);
		t2.setName("窗口3");

		
		//冲突的例子见：Eg03_Runnable.java
		t.start();// 线程运行
		t1.start();
		t2.start();
	}
}
