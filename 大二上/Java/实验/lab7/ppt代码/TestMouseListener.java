package cn.edu.zjut.java.ch09;

import javax.swing.*;
 

public class TestMouseListener extends JFrame {
	private static final long serialVersionUID = 1L;

	TestMouseListener() {
		super(" Û±ÍŒª÷√");
		setContentPane(new MousePanel());
	}

	public static void main(String args[]) {
		TestMouseListener f = new TestMouseListener();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 280);
		f.setVisible(true); 
	}
}


