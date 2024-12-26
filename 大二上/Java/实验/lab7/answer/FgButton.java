package cn.edu.zjut.java.exp06;

import javax.swing.Icon;
import javax.swing.JButton;

public class FgButton extends JButton {
	private static final long serialVersionUID = 1L;

	public FgButton() {
		super();
	}

	public FgButton(Icon icon) {
		super(icon);
	}

	public FgButton(Icon icon, String strToolTipText) {
		super(icon);
		setToolTipText(strToolTipText);
	}

	public FgButton(String text) {
		super(text);
	}

	public FgButton(String text, Icon icon, String strToolTipText) {
		super(text, icon);
		setToolTipText(strToolTipText);
	}
}
