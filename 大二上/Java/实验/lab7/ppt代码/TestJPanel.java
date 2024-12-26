package cn.edu.zjut.java.ch09;

import java.awt.Color;
import java.awt.Container;
import javax.swing.*;

/**
 * JPanel是一种轻量级的中间容器，称为面板组件，
 * 可以在它上面添加其他组件（包括其他面板组件）。
 * 面板(JPanel)的大小随着其包含的组件多少而变大变小。
 * 
 * Container(Content Pane) --> JPanel
 */

public class TestJPanel extends JFrame {

	private static final long serialVersionUID = 1L;

	public TestJPanel(String sTitle) {
		super(sTitle);
		setSize(400, 300);// 设置大小
		
		// 获取窗口面板(Content Pane);
		Container c = getContentPane();
		c.setBackground(Color.RED); // 窗口背景红色
		c.setLayout(null);// 取消布局器
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW); // pan背景黄色
		panel.setSize(200, 100);
		add(panel);// 用add方法把面板pan添加到窗口中
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		TestJPanel frm = new TestJPanel("JFrame with JPanel");
		frm.setVisible(true);
	}
}
