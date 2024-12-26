package cn.edu.zjut.java.ch09;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

//�Զ��嵥���ı��򣬴�JTextField�̳й���
class FgTextField extends JTextField {
	private static final long serialVersionUID = 1L;
	boolean m_bOnlyInteger;// ����ָʾ�Ƿ�ֻ������������

	FgTextField(String sText, int columns, boolean bOnlyInteger) {
		super(sText, columns);

		m_bOnlyInteger = bOnlyInteger;
		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (m_bOnlyInteger) {
					char c = e.getKeyChar();
					if (c < '0' | c > '9')
						e.consume(); // ȡ������
				}
			}
		});
	}
}
