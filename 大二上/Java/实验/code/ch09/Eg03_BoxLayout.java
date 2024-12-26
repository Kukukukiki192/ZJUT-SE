package cn.edu.zjut.java.ch09;

import java.awt.*;
import javax.swing.*;

public class Eg03_BoxLayout {
	public static void main(String[] args) {
		JPanel  jp=new JPanel();
		//面板布局设置为BoxLayout，沿Y轴从上到下排列
		jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
		//将JTextArea与JButton添加到面板中
		JTextArea  testArea=new JTextArea("This is a multiple text field",4,20);
		JButton   button=new JButton("This is a button");
		jp.add(testArea);
		jp.add(button);
		//设置JTextArea的右边与JButton的左边对齐
		testArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button.setAlignmentX(Component.LEFT_ALIGNMENT);
				
		JFrame frm=new JFrame("JFrame with BoxLayout");
		frm.setContentPane(jp);//替换掉默认的内容面板
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(400, 200);
		frm.setVisible(true);

	}
}
