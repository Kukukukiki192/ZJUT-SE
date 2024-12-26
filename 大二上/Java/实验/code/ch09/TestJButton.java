package cn.edu.zjut.java.ch09;

import java.awt.*;
import javax.swing.*;

public class TestJButton extends JFrame {
	TestJButton(String sTitle) {
		super(sTitle);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		// 两个按钮上的图标
		ImageIcon[] ic = { new ImageIcon(ImageScaling.zoom("src/img/new.png", 0.1)), new ImageIcon(ImageScaling.zoom("src/img/open.png", 0.1)) };
		// 三个按钮
		JButton[] btn = { new JButton("新建", ic[0]), new JButton("中间"), new JButton("打开", ic[1]) };
		int i;
		for (i = 0; i < btn.length; i++)
			c.add(btn[i]);
		// btn[0]的文字在图标左侧
		btn[0].setHorizontalTextPosition(SwingConstants.LEFT);
		// 两个复选框
		JCheckBox[] ck = { new JCheckBox("左"), new JCheckBox("右") };
		for (i = 0; i < ck.length; i++) {
			c.add(ck[i]);
			ck[i].setSelected(true);// 将复选框设置为选中状态
		}
		// 两个单选框
		JRadioButton[] r = { new JRadioButton("左"), new JRadioButton("右") };
		ButtonGroup rg = new ButtonGroup();
		for (i = 0; i < r.length; i++) {
			c.add(r[i]);
			rg.add(r[i]);// 组成ButtonGroup，这样二者只能同时选中一项
		}
		// 设置单选框的选择状态
		r[0].setSelected(true);
		r[1].setSelected(true);

		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		TestJButton frm = new TestJButton("JFrame with JButton");
		frm.setVisible(true);
	}
}
