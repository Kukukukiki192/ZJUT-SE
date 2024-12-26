package cn.edu.zjut.java.ch09;

import java.awt.*;

import javax.swing.JFrame;

public class Eg01_FlowLayout {
	public static void main(String[] args) {
		JFrame frame = new JFrame("FlowLayoutDemo");
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 80));
		//frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		
//		Button[] buttonArray = new Button[10];
//
//		int length = buttonArray.length;
//		for (int i = 0; i < length; i++) {
//			buttonArray[i] = new Button("°´Å¥" + (i + 1));
//		}
		
		for (int i = 0; i < 10; i++) {
			//frame.add(buttonArray[i]);
			frame.add(new Button("°´Å¥" + (i + 1)));
		}
		
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
