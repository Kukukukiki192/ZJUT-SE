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
		// ���췽����JTree()
		JTree example1 = new JTree();
		// ���췽����JTree(Object[] value)
		Object[] letters = { "a", "b", "c", "d", "e" };
		JTree example2 = new JTree(letters);
		// ���캯����JTree(TreeNode root)������rootΪһ���սڵ�
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(); // �������ڵ�
		// �ô����ڵ����������� JTree�Ĺ��캯����������һ�����ڵ����
		JTree example3 = new JTree(node1);
		// ���캯����JTree(TreeNode root)(ͬ��,ֻ��root�ǿ�)
		// ��һ�����ڵ㴴����
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Color");
		JTree example4 = new JTree(node2); // �ڵ���ɫĬ��Ϊ�׵׺���
		example4.setBackground(Color.lightGray);// ���ýڵ�ı�����ɫ

		// ���캯����JTree(TreeNode root, boolean asksAllowsChildren)
		// ʹ��DefaultMutableTreeNode�����ø���㴴����������Ϊ����Ӻ��ӽ��,
		// ����Ӻ��ӽ��
		DefaultMutableTreeNode color = new DefaultMutableTreeNode("Color", true);
		DefaultMutableTreeNode gray = new DefaultMutableTreeNode("Gray");
		color.add(gray);
		color.add(new DefaultMutableTreeNode("Red"));
		gray.add(new DefaultMutableTreeNode("Lightgray"));
		gray.add(new DefaultMutableTreeNode("Darkgray"));
		color.add(new DefaultMutableTreeNode("Green"));
		JTree example5 = new JTree(color);
		// ���캯����JTree(TreeNode root)(ͬ��,ֻ��root�ǿ�)
		// �ȴ��������ڵ�
		DefaultMutableTreeNode biology = new DefaultMutableTreeNode("Biology");
		DefaultMutableTreeNode animal = new DefaultMutableTreeNode("Animal");
		DefaultMutableTreeNode mammal = new DefaultMutableTreeNode("Mammal");
		DefaultMutableTreeNode horse = new DefaultMutableTreeNode("Horse");
		mammal.add(horse);
		animal.add(mammal);
		biology.add(animal);
		// ���ݴ����õĽڵ㴴����
		JTree example6 = new JTree(biology);
		// ��ȡ����ʾmammal��·��
		TreePath p = new TreePath(mammal.getPath());
		example6.expandPath(p);
		JOptionPane.showMessageDialog(frm, p.toString(), "Path of Mammal TreeNode", JOptionPane.INFORMATION_MESSAGE);
		// ����Щ����ӵ����������
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));
		pan.setPreferredSize(new Dimension(600, 200));
		pan.add(new JScrollPane(example1));
		pan.add(new JScrollPane(example2));
		pan.add(new JScrollPane(example3));
		pan.add(new JScrollPane(example4));
		pan.add(new JScrollPane(example5));
		pan.add(new JScrollPane(example6));

		try {// ����ʹ��Windows������
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// ����JTree��UI���
			SwingUtilities.updateComponentTreeUI(example1);
			SwingUtilities.updateComponentTreeUI(example6);
		} catch (Exception e) {
		}
		// ���ô�������
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setContentPane(pan);
		frm.pack();
		frm.setVisible(true);
	}
}
