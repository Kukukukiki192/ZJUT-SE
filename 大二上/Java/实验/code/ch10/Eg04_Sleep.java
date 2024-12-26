package cn.edu.zjut.java.ch10;

public class Eg04_Sleep extends Thread {

	public void run() {
		long start = System.nanoTime();
		for (int i = 0; i < 10; i++) {
			System.out.println("睡眠：" + i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long end = System.nanoTime();
		System.out.println("总的运行时间:" + (end - start) / 1000000 + "毫秒");
	}

	public static void main(String[] arg) {
		Eg04_Sleep t1 = new Eg04_Sleep();
		t1.start();
	}
}

