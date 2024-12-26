package com.pattern.singleton.hw;


public class AccessLimitInstanceClassThread extends Thread {
	String threadName=new String();
	public AccessLimitInstanceClassThread(String threadName) {
		this.threadName=threadName;
	}

	public void run(){
		//获取一个LimitInstanceClass对象
		LimitInstanceClass limitInstance= LimitInstanceClass.getInstance();
		//将自己的线程名写入accessMessage
		limitInstance.writeAccessMessage(threadName);
		try { //随机休眠0-5秒
			Thread.sleep((int)(Math.random()*5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		limitInstance.printAccessMessage();
		limitInstance.release();
	}
}