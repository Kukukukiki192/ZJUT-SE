package cn.edu.zjut.java.ch10;

/**
 * һ����̨(Daemon)�߳���һ���ڱ���ִ�з�����߳�;
 * ������еķ�Daemon���̶߳������ˣ���Daemon�߳��Զ��ͻ���ֹ;
 * ��Main������ʼ����һ����Daemon�߳�;
 * ���ϣ��ĳ���߳��ڲ��������߳̽����������ֹ��Ҫ������ΪDaemon�߳�.
 */







public class DaemonThread extends Thread {
	public DaemonThread() {
		// ���߳�����֮ǰ���ú�̨�߳�
		setDaemon(true);
		start(); // �����߳�
	}
	 
	
	
}
