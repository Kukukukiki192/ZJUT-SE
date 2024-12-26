package cn.edu.zjut.java.ch09;

import java.awt.*;

import javax.swing.*;
 
import java.awt.Color;

public class Eg04_GridLayout {
	public static void main(String args[]) {
		
		
		try{ 
			//���·����Nimbus
			String lfClassName="com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
			UIManager.setLookAndFeel(lfClassName);//������۷��
			//����UI���
			 
			} 
			catch (Exception e) { }
		
		
		JFrame f = new JFrame("JFrame with GridLayout");
		Container c = f.getContentPane();

		c.setLayout(new GridLayout(3, 2));// 3��2��
		
		JComponent[] ctls = { new JCheckBox("1 - CheckBox"),
				new JCheckBox("2 - CheckBox"),
				new JRadioButton("3 - RadioButton"),
				new JRadioButton("4 - RadioButton"), 
				new JButton("OK"),
				new JButton("CANCEL") };

		for (int i = 0; i < ctls.length; i++) {
			c.add(ctls[i]);// ���ϵ��£�������������
			// ���ñ߿�
			if (i >= 0 & i < 2)
				((JCheckBox) ctls[i]).setBorderPainted(true);
			if (i >= 2 & i < 4)
				((JRadioButton) ctls[i]).setBorderPainted(true);
			ctls[i].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		}
		
		f.setSize(400, 200); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
