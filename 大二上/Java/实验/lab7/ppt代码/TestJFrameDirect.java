package cn.edu.zjut.java.ch09;

import java.awt.event.*;
import javax.swing.*;

/**
 * 我的第一个java窗口程序:
 *   JFrame-->JMenuBar-->JMenu-->JMenuItem
 */

public class TestJFrameDirect {
	// **********************************************************
	// 以下为成员变量（对象）的定义
	// 定义菜单
	static JMenuBar mb = new JMenuBar();// 菜单栏
	static FgMenu mFile = new FgMenu("文件(F)", KeyEvent.VK_F);// "文件"菜单  继承 用于实现快捷键
	static JMenuItem miNew = new JMenuItem("新建(N)", KeyEvent.VK_N),
			miOpen = new JMenuItem("打开(O)...", KeyEvent.VK_O),
			miSave = new JMenuItem("保存(S)", KeyEvent.VK_S),
			miFont = new JMenuItem("字体与颜色(F)...", KeyEvent.VK_F),
			miQuit = new JMenuItem("退出(X)", KeyEvent.VK_X);

	// ************************************************************
	public static void main(String args[]) {
		// ①：创建窗口对象，窗口标题通过构造方法传递进去
		JFrame frm = new JFrame("这是我的第一个窗口应用程序");
		
		// ②：添加组件。本例中直接添加菜单
		frm.setJMenuBar(mb);
		mFile.add(miNew);// 新建
		mFile.add(miOpen);// 打开
		mFile.add(miSave);// 保存
		mFile.addSeparator();// 分割条
		mFile.add(miFont);// 字体与颜色菜单
		mFile.addSeparator();// 分割条
		mFile.add(miQuit);// 退出
		mb.add(mFile); // 将"文件"菜单添加到菜单栏上
		
		// ③：设置窗口位置和大小
		frm.setBounds(100, 200, 400, 600);
		
		// 设置close按钮的操作
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ④：显示窗口
		frm.setVisible(true);
	}

}
