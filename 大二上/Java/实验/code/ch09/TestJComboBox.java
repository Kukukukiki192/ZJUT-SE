package cn.edu.zjut.java.ch09;

import java.awt.*;

import javax.swing.*;

public class TestJComboBox extends JFrame {

	JComboBox cbxFont = new JComboBox();
	JComboBox cbxFontSize = new JComboBox();// 字体大小

	TestJComboBox(String sTitle) {
		super(sTitle);

		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));

		c.add(new JLabel("字体名称："));
		c.add(cbxFont);
		c.add(new JLabel("字体大小："));
		c.add(cbxFontSize);

		// 初始化字体与大小下拉框
		InitFonts();

		setSize(300, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 初始化字体框
	private void InitFonts() {
		// 获得系统的字体数组
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontList = ge.getAvailableFontFamilyNames();
		int i;

		// 添加字体名称
		for (i = 0; i < fontList.length; i++)
			cbxFont.addItem(String.valueOf(i) + "  |  " + fontList[i]);

		cbxFont.setSelectedIndex(231);// 选择index为231的项
		// 添加字体大小
		for (i = 9; i <= 72; i++)
			cbxFontSize.addItem(new Integer(i).toString());
		cbxFontSize.setSelectedIndex(3);// 选择index为3的项
	}

	public static void main(String args[]) {
		TestJComboBox frm = new TestJComboBox("JFrame with JComboBox");
		frm.setVisible(true);
	}

}
