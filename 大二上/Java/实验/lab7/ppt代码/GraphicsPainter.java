package cn.edu.zjut.java.ch09;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsPainter // Test为自定义的主类名，一般大写
{
	public static void main(String args[]) {
		JFrame newFrame = new JFrame("funBox");
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 定义JFrame关闭时的操作（必需），有效避免不能关闭后台当前框体进程的问题
		newFrame.setSize(400, 400); // 定义JFrame的相关属性
		newFrame.setLocation(200, 200);
		newFrame.setVisible(true);
		newFrame.add(new Rect());
	}
}

class Rect extends JPanel // FangKuai 为自定义新建类名
{
	public void paint(Graphics g) // 重写实现panit()方法
	{
		g.setColor(Color.green);  
		g.fillRect(100, 100, 20, 20);

		g.setColor(Color.red);  
		g.drawLine(10, 10, 50, 50);
	}
}