package cn.edu.zjut.java.ch09;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.table.TableColumn;

public class TestJTable {
	public static void main(String[] args) {
		JTable table1 = new JTable(12, 6);// 12行6列的空表格
		// 定义列名与行数据，其中列名最好用final修饰
		final Object[] columnNames = { "姓名", "性别", "家庭地址", "电话号码", "生日" };
		Object[][] rowData = { { "张国伟", "男", "浙江杭州", "1378313210", "1985-03-24" },
				{ "叶苛", "女", "浙江金华", "13645181705", "1985-05-05" }, { "程陈", "男", "江苏南京", "13585331486", "1985-12-08" },
				{ "曹艳", "女", "浙江温州", "81513779", "1986-10-01" }, { "刘飞", "男", "浙江宁波", "13651545936", "1985-12-25" } };
		// 创建表格
		JTable table2 = new JTable(rowData, columnNames);
		// 设置表格属性
		table2.setRowHeight(30);// 设置每行的高度为30
		table2.setRowHeight(0, 20);// 设置第1行的高度为20，作为区别
		table2.setRowMargin(5);// 设置相邻两行的距离
		table2.setRowSelectionAllowed(true);// 设置可否被选择，默认为false
		table2.setSelectionBackground(Color.BLUE);// 设置所选择行的背景颜色
		table2.setSelectionForeground(Color.WHITE);// 设置所选择行的前景色
		table2.setGridColor(Color.BLACK);// 设置网格线的颜色
		table2.setRowSelectionInterval(0, 2);// 设置初始的选择行(1到3行)
		table2.setShowHorizontalLines(false);// 是否显示水平的网格线
		table2.setShowVerticalLines(true);// 是否显示垂直的网格线
		table2.setValueAt("无名氏", 0, 0);// 设置某个单元格的值,这个值是一个对象
		table2.doLayout();
		table2.setBackground(Color.lightGray);// 设置表格背景色
		// 设置表格的大小
		table2.setPreferredScrollableViewportSize(new Dimension(600, 100));
		// 创建窗口中将要用到的面板
		JScrollPane pane1 = new JScrollPane(table1);
		JScrollPane pane2 = new JScrollPane(table2);
		JPanel pan = new JPanel(new GridLayout(0, 1));
		pan.setPreferredSize(new Dimension(600, 250));
		pan.setBackground(Color.black);
		pan.add(pane1);
		pan.add(pane2);
		// 创建窗口
		JFrame frm = new JFrame("JFrame with JTable");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setContentPane(pan);
		frm.pack();
		frm.setVisible(true);
	}
}
