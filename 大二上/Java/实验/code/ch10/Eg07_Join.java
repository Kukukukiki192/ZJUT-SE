package cn.edu.zjut.java.ch10;

/**
 * join()方法是让一个线程等待另一个线程的完成，比如t1、t2是两个线程对象，
 * 在t1中调用了t2.join()，就会导致t1线程暂停执行，
 * 一直等待到t2线程完成了，t1才会恢复执行。
 */

public class Eg07_Join extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {// 线程循环10次输出字符
			System.out.println(Thread.currentThread().getName() + "第" + i
					+ "次输出");
		}
		System.out.println(Thread.currentThread().getName() + "运行结束");
	}

	public static void main(String[] arg) {
		System.out.println("【主线程】开始运行");// main主线程开始运行
		Eg07_Join t = new Eg07_Join();
		t.setName("线程1");// 给线程命名
		
		try {
			long start = System.nanoTime();
			t.start();
			//t.join();// 在main线程中调用了join，那么久会等待t线程执行完毕，再继续。
			//测试注释掉这行，输出是怎么样子的？？
			// 计算t线程运行了多少时间
			long end = System.nanoTime();
			System.out.println("【" + t.getName() + "】耗时" + (end - start) / 1000000 + "毫秒");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("【主线程】运行结束");// 主线程运行结束
	}
}
