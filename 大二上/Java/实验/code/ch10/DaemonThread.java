package cn.edu.zjut.java.ch10;

/**
 * 一个后台(Daemon)线程是一个在背景执行服务的线程;
 * 如果所有的非Daemon的线程都结束了，则Daemon线程自动就会终止;
 * 从Main方法开始的是一个非Daemon线程;
 * 如果希望某个线程在产生它的线程结束后跟着终止，要将它设为Daemon线程.
 */







public class DaemonThread extends Thread {
	public DaemonThread() {
		// 在线程启动之前设置后台线程
		setDaemon(true);
		start(); // 启动线程
	}
	 
	
	
}
