package cn.edu.zjut.java.ch09;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.BoxLayout;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

public class TestJTree {
	public static void main(String[] args) {
		JFrame frm = new JFrame("JFrame with JTree");
		// 构造方法：JTree()
		JTree example1 = new JTree();
		// 构造方法：JTree(Object[] value)
		Object[] letters = { "a", "b", "c", "d", "e" };
		JTree example2 = new JTree(letters);
		// 构造函数：JTree(TreeNode root)，但是root为一个空节点
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(); // 定义树节点
		// 用此树节点做参数调用 JTree的构造函数创建含有一个根节点的树
		JTree example3 = new JTree(node1);
		// 构造函数：JTree(TreeNode root)(同上,只是root非空)
		// 用一个根节点创建树
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Color");
		JTree example4 = new JTree(node2); // 节点颜色默认为白底黑字
		example4.setBackground(Color.lightGray);// 设置节点的背景颜色

		// 构造函数：JTree(TreeNode root, boolean asksAllowsChildren)
		// 使用DefaultMutableTreeNode类先用根结点创建树，设置为可添加孩子结点,
		// 再添加孩子结点
		DefaultMutableTreeNode color = new DefaultMutableTreeNode("Color", true);
		DefaultMutableTreeNode gray = new DefaultMutableTreeNode("Gray");
		color.add(gray);
		color.add(new DefaultMutableTreeNode("Red"));
		gray.add(new DefaultMutableTreeNode("Lightgray"));
		gray.add(new DefaultMutableTreeNode("Darkgray"));
		color.add(new DefaultMutableTreeNode("Green"));
		JTree example5 = new JTree(color);
		// 构造函数：JTree(TreeNode root)(同上,只是root非空)
		// 先创建各个节点
		DefaultMutableTreeNode biology = new DefaultMutableTreeNode("Biology");
		DefaultMutableTreeNode animal = new DefaultMutableTreeNode("Animal");
		DefaultMutableTreeNode mammal = new DefaultMutableTreeNode("Mammal");
		DefaultMutableTreeNode horse = new DefaultMutableTreeNode("Horse");
		mammal.add(horse);
		animal.add(mammal);
		biology.add(animal);
		// 根据创建好的节点创建树
		JTree example6 = new JTree(biology);
		// 获取并显示mammal的路径
		TreePath p = new TreePath(mammal.getPath());
		example6.expandPath(p);
		JOptionPane.showMessageDialog(frm, p.toString(), "Path of Mammal TreeNode", JOptionPane.INFORMATION_MESSAGE);
		// 将这些树添加到窗口面板中
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));
		pan.setPreferredSize(new Dimension(600, 200));
		pan.add(new JScrollPane(example1));
		pan.add(new JScrollPane(example2));
		pan.add(new JScrollPane(example3));
		pan.add(new JScrollPane(example4));
		pan.add(new JScrollPane(example5));
		pan.add(new JScrollPane(example6));

		try {// 设置使用Windows风格外观
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// 更新JTree的UI外观
			SwingUtilities.updateComponentTreeUI(example1);
			SwingUtilities.updateComponentTreeUI(example6);
		} catch (Exception e) {
		}
		// 设置窗口属性
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setContentPane(pan);
		frm.pack();
		frm.setVisible(true);
	}
}
