package cn.edu.zjut.java.ch09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Eg05_CardLayout implements MouseListener {
	CardLayout layout = new CardLayout();
	JFrame f = new JFrame("JFrame with CardLayout");
	Container c;
	JButton page1Button;
	JLabel page2Label; // 标签,一行文本
	JTextArea page3Text; // 多行多列的文本区域
	JButton page3Top;
	JButton page3Bottom;
	
	public Eg05_CardLayout(){


	}

	public static void main(String args[]) {
		
		Eg05_CardLayout frm = new Eg05_CardLayout();
		frm.show();
	}

	public void mouseClicked(MouseEvent arg0) {
		layout.next(c);
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void show() {
		c = f.getContentPane();
		c.setLayout(layout); // 设置为CardLayout
		
		// 第一张Card放了一个JButton
		c.add(page1Button = new JButton("1st Card: Button page"), "page1Button");
		page1Button.addMouseListener(this); // 注册监听器

		// 第二张Card放了一个JLabel
		c.add(page2Label = new JLabel("2nd Card: Label page"), "page2Label");
		page2Label.addMouseListener(this); // 注册监听器

		// 第三张Card放一个JPanel，在这个JPanel上又放了一个JTextArea、两个JButton
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(page3Text = new JTextArea("3rd Card: Composite page"), "Center");
		page3Text.addMouseListener(this);
		pan.add(page3Top = new JButton("Top button"), "North");
		page3Top.addMouseListener(this);
		pan.add(page3Bottom = new JButton("Bottom button"), "South");
		page3Bottom.addMouseListener(this);
		c.add(pan, "panel");

		f.setSize(180, 120);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
