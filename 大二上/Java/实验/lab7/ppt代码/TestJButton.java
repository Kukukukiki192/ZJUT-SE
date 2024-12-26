package cn.edu.zjut.java.ch09;

import java.awt.*;
import javax.swing.*;

public class TestJButton extends JFrame {
	TestJButton(String sTitle) {
		super(sTitle);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		// ������ť�ϵ�ͼ��
		ImageIcon[] ic = { new ImageIcon(ImageScaling.zoom("src/img/new.png", 0.1)), new ImageIcon(ImageScaling.zoom("src/img/open.png", 0.1)) };
		// ������ť
		JButton[] btn = { new JButton("�½�", ic[0]), new JButton("�м�"), new JButton("��", ic[1]) };
		int i;
		for (i = 0; i < btn.length; i++)
			c.add(btn[i]);
		// btn[0]��������ͼ�����
		btn[0].setHorizontalTextPosition(SwingConstants.LEFT);
		// ������ѡ��
		JCheckBox[] ck = { new JCheckBox("��"), new JCheckBox("��") };
		for (i = 0; i < ck.length; i++) {
			c.add(ck[i]);
			ck[i].setSelected(true);// ����ѡ������Ϊѡ��״̬
		}
		// ������ѡ��
		JRadioButton[] r = { new JRadioButton("��"), new JRadioButton("��") };
		ButtonGroup rg = new ButtonGroup();
		for (i = 0; i < r.length; i++) {
			c.add(r[i]);
			rg.add(r[i]);// ���ButtonGroup����������ֻ��ͬʱѡ��һ��
		}
		// ���õ�ѡ���ѡ��״̬
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
