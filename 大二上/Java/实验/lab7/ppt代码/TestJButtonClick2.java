package cn.edu.zjut.java.ch09;

import java.awt.*;
import java.awt.event.*;//�ڢٲ��������¼���
import javax.swing.*;

// �ڢڲ�����������һ��������implementsĳ���������ӿ�
class JButtonHandler implements ActionListener {
	// �ڢܲ�����������μ���
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "�����˰�ť\"" + e.getActionCommand()
				+ "\"", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
	}
}

// �¼����������¼�Դ������ͬһ����
public class TestJButtonClick2 {
	TestJButtonClick2() {
		JFrame f = new JFrame("�¼����������¼�Դ���ڵ������");
		Container c = f.getContentPane();
		JButton b = new JButton("Press Me!");

		b.addActionListener(new JButtonHandler());// �ڢ۲���ע�������
		c.add(b, "Center");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(200, 100);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		new TestJButtonClick2();
	}
}


