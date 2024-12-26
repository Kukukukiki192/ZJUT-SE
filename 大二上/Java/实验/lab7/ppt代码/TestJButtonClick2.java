package cn.edu.zjut.java.ch09;

import java.awt.*;
import java.awt.event.*;//第①步，引入事件包
import javax.swing.*;

// 第②步，单独定义一个类声明implements某个监听器接口
class JButtonHandler implements ActionListener {
	// 第④步，监听者如何监听
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "你点击了按钮\"" + e.getActionCommand()
				+ "\"", "提示", JOptionPane.INFORMATION_MESSAGE);
	}
}

// 事件监听者与事件源不属于同一个类
public class TestJButtonClick2 {
	TestJButtonClick2() {
		JFrame f = new JFrame("事件监听者与事件源所在的类分离");
		Container c = f.getContentPane();
		JButton b = new JButton("Press Me!");

		b.addActionListener(new JButtonHandler());// 第③步，注册监听者
		c.add(b, "Center");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(200, 100);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		new TestJButtonClick2();
	}
}


