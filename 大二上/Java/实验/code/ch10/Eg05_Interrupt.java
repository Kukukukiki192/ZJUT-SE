package cn.edu.zjut.java.ch10;

/**
 * interrupt方法会中断线程的休眠
 */

public class Eg05_Interrupt extends Thread {
	public void run() {
		long start = System.nanoTime();
		System.out.println("线程睡眠");
		
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("线程被唤醒");
		}
		
		long end = System.nanoTime();
		System.out.println("总的运行时间:" + (end - start) / 1000000 + "毫秒");
	}

	public static void main(String[] arg) {
		Eg05_Interrupt t1 = new Eg05_Interrupt();
		t1.start();
		
		t1.interrupt();   //显示多少运行多少时间呢？？
	}
}
