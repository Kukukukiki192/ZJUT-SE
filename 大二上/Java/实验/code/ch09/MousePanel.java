package cn.edu.zjut.java.ch09;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

class MousePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	int x_pos, y_pos;

	MousePanel() {
		// ע������¼���������������������ʵ���¼��������
		// ע�⣬����ʵ��(����)�ӿ��е�ȫ������������ʵ�ִ���һ��Ҳû��
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				x_pos = e.getX();
				y_pos = e.getY();
				repaint();// ���������Զ�����paintComponent����������
			}
		});

		// ע������ƶ��¼���������������������ʵ���¼��������
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
			}

			public void mouseMoved(MouseEvent e) {
				x_pos = e.getX();
				y_pos = e.getY();
				repaint();// ���������Զ�����paintComponent����������
			}
		});

		// �����̳�MouseAdapter��
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x_pos = e.getX();
				y_pos = e.getY();
				repaint();
			}
		});
		
		// �����̳�MouseMotionAdapter��
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				x_pos = e.getX();
				y_pos = e.getY();
				repaint();
			}
		});

	}

	// ���Ǹ����paintComponent�����Ի��Ƶ�ǰ��������
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("��ǰλ�ã�[" + x_pos + ", " + y_pos + "]", x_pos, y_pos);
		//g.draw
		//g.draw More stuff
	}
}
