package cn.edu.zjut.java.ch09;

import java.awt.*;
import javax.swing.*;

public class TestJList extends JFrame {
	// 声明列表框对象
	JList listNames = new JList();

	TestJList(String sTitle) {
		super(sTitle);

		Container c = getContentPane();
		// 以下语句保证列表框数据较多时会出现滚动条
		JScrollPane scrollPane = new JScrollPane(listNames);
		c.add(scrollPane);
		// 初始化列表框
		InitList();
		setSize(250, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 初始化列表框
	private void InitList() {
		String[] names = { "201126100101 - 曹帝胄", "201126100111 - 洪峰", "201126100128 - 徐华鹏", "201126100131 - 姚臻平",
				"201126100202 - 陈思行", "201126100207 - 姜楠", "201126100210 - 林一民", "201126100211 - 林泽伟" };
		// 用数组填充列表框
		listNames.setListData(names);
		// 将1、3的项(201126100111和201126100131)设置为选择状态
		listNames.setSelectedIndices(new int[] { 1, 3 });
	}

	public static void main(String args[]) {
		TestJList frm = new TestJList("JFrame with JList");
		frm.setVisible(true);
	}
}
