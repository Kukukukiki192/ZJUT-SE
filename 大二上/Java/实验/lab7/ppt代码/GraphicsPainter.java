package cn.edu.zjut.java.ch09;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsPainter // TestΪ�Զ������������һ���д
{
	public static void main(String args[]) {
		JFrame newFrame = new JFrame("funBox");
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����JFrame�ر�ʱ�Ĳ��������裩����Ч���ⲻ�ܹرպ�̨��ǰ������̵�����
		newFrame.setSize(400, 400); // ����JFrame���������
		newFrame.setLocation(200, 200);
		newFrame.setVisible(true);
		newFrame.add(new Rect());
	}
}

class Rect extends JPanel // FangKuai Ϊ�Զ����½�����
{
	public void paint(Graphics g) // ��дʵ��panit()����
	{
		g.setColor(Color.green);  
		g.fillRect(100, 100, 20, 20);

		g.setColor(Color.red);  
		g.drawLine(10, 10, 50, 50);
	}
}