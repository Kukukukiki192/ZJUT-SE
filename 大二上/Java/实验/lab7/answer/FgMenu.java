package cn.edu.zjut.java.exp06;

import javax.swing.JMenu;

// �Զ���˵�
public class FgMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	public FgMenu(String label) {
		super(label);
	}

	public FgMenu(String label, int nAccelerator) {
		super(label);
		setMnemonic(nAccelerator);
	}
}
