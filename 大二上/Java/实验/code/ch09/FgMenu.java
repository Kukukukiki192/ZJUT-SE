package cn.edu.zjut.java.ch09;

import javax.swing.JMenu;

// 自定义菜单
class FgMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	public FgMenu(String label) {
		super(label);
	}

	public FgMenu(String label, int nAccelerator) {
		super(label);
		setMnemonic(nAccelerator);
	}
}
