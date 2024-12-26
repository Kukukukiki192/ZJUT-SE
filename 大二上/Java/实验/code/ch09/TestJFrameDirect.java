package cn.edu.zjut.java.ch09;

import java.awt.event.*;
import javax.swing.*;

/**
 * �ҵĵ�һ��java���ڳ���:
 *   JFrame-->JMenuBar-->JMenu-->JMenuItem
 */

public class TestJFrameDirect {
	// **********************************************************
	// ����Ϊ��Ա���������󣩵Ķ���
	// ����˵�
	static JMenuBar mb = new JMenuBar();// �˵���
	static FgMenu mFile = new FgMenu("�ļ�(F)", KeyEvent.VK_F);// "�ļ�"�˵�  �̳� ����ʵ�ֿ�ݼ�
	static JMenuItem miNew = new JMenuItem("�½�(N)", KeyEvent.VK_N),
			miOpen = new JMenuItem("��(O)...", KeyEvent.VK_O),
			miSave = new JMenuItem("����(S)", KeyEvent.VK_S),
			miFont = new JMenuItem("��������ɫ(F)...", KeyEvent.VK_F),
			miQuit = new JMenuItem("�˳�(X)", KeyEvent.VK_X);

	// ************************************************************
	public static void main(String args[]) {
		// �٣��������ڶ��󣬴��ڱ���ͨ�����췽�����ݽ�ȥ
		JFrame frm = new JFrame("�����ҵĵ�һ������Ӧ�ó���");
		
		// �ڣ���������������ֱ����Ӳ˵�
		frm.setJMenuBar(mb);
		mFile.add(miNew);// �½�
		mFile.add(miOpen);// ��
		mFile.add(miSave);// ����
		mFile.addSeparator();// �ָ���
		mFile.add(miFont);// ��������ɫ�˵�
		mFile.addSeparator();// �ָ���
		mFile.add(miQuit);// �˳�
		mb.add(mFile); // ��"�ļ�"�˵���ӵ��˵�����
		
		// �ۣ����ô���λ�úʹ�С
		frm.setBounds(100, 200, 400, 600);
		
		// ����close��ť�Ĳ���
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �ܣ���ʾ����
		frm.setVisible(true);
	}

}
