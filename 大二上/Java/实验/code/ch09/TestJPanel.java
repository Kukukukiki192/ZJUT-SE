package cn.edu.zjut.java.ch09;

import java.awt.Color;
import java.awt.Container;
import javax.swing.*;

/**
 * JPanel��һ�����������м���������Ϊ��������
 * ������������������������������������������
 * ���(JPanel)�Ĵ�С�����������������ٶ�����С��
 * 
 * Container(Content Pane) --> JPanel
 */

public class TestJPanel extends JFrame {

	private static final long serialVersionUID = 1L;

	public TestJPanel(String sTitle) {
		super(sTitle);
		setSize(400, 300);// ���ô�С
		
		// ��ȡ�������(Content Pane);
		Container c = getContentPane();
		c.setBackground(Color.RED); // ���ڱ�����ɫ
		c.setLayout(null);// ȡ��������
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW); // pan������ɫ
		panel.setSize(200, 100);
		add(panel);// ��add���������pan��ӵ�������
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		TestJPanel frm = new TestJPanel("JFrame with JPanel");
		frm.setVisible(true);
	}
}
