package cn.edu.zjut.java.ch09;

import javax.swing.*;
 
import java.awt.*;

public class Eg02_BorderLayout {
	public static void main(String args[]) {
		JFrame frm = new JFrame("JFrame with BorderLayout");
		
		frm.setLayout(new BorderLayout());

		// North放置一个按钮
		frm.add("North", new JButton("North"));
		
		// South放置一个下拉框JComboBox
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("0 - First Item");
		jcb.addItem("1 - Second Item");
		jcb.setSelectedIndex(1);

		frm.add("South", jcb);
		
		// East放置一个单选框JRadioButton
		// frm.add(BorderLayout.EAST, new JRadioButton("East"));
		frm.add("East", new JRadioButton("East"));
		// West放置一个复选框JCheckBox
		frm.add(new JCheckBox("West"), BorderLayout.WEST);
		
		// Center放置一个单行文本框JTextField
		frm.add("Center", new JTextField("Center"));
		
		// 窗口属性
		frm.setSize(400, 300); 
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
