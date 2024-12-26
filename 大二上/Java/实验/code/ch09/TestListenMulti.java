package cn.edu.zjut.java.ch09;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;//监听多个组件 

public class TestListenMulti extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JTextField txtNumber;
	JButton btnInc, btnDec;

	public void initComponents() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		// c.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
		
		// 添加单行框
		txtNumber = new JTextField("0", 20);
		c.add(txtNumber);
		
		// btnInc按钮
		btnInc = new JButton("∧");
		c.add(btnInc);
		btnInc.addActionListener(this);
		
		// btnDec按钮
		btnDec = new JButton("∨");
		c.add(btnDec);
		btnDec.addActionListener(this);
		// catch (Exception e){}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	TestListenMulti(String sTitle) {
		super(sTitle);
		initComponents();
	}

	public void actionPerformed(ActionEvent e) {
		int oldNum = Integer.parseInt(txtNumber.getText());
		int newNum = oldNum;
		if (e.getSource() == btnInc)// 点击了btnInc按钮
			newNum++;
		else if (e.getSource() == btnDec)// 点击了btnDec按钮
			newNum--;

		txtNumber.setText(String.valueOf(newNum));
	}

	public static void main(String args[]) {
		TestListenMulti f = new TestListenMulti("监听多个组件事件");
		f.setSize(500, 200);
		f.setVisible(true);
	}
}
