package cn.edu.zjut.java.ch09;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
 

/**
 * �ҵ���һ��java���ڳ��� ͨ����JFrame�̳еõ��Զ���Ĵ����ࣺTestJFrameExtends
 */

public class TestJFrameExtends extends JFrame {
	private static final long serialVersionUID = 1L;

	private final static String projPath = System.getProperty("user.dir");
	private final static String new_icon = projPath + "/src/img/new.png";
	private final static String save_icon = projPath + "/src/img/save.png";
	private final static String open_icon = projPath + "/src/img/open.png";

	static JMenuBar mb = new JMenuBar();// �˵���
	static FgMenu mFile = new FgMenu("�ļ�(F)", KeyEvent.VK_F);// "�ļ�"�˵�
	static JMenuItem miNew = new JMenuItem("�½�(N)", KeyEvent.VK_N),
			miOpen = new JMenuItem("��(O)...", KeyEvent.VK_O),
			miSave = new JMenuItem("����(S)", KeyEvent.VK_S),
			miFont = new JMenuItem("��������ɫ(F)...", KeyEvent.VK_F),
			miQuit = new JMenuItem("�˳�(X)", KeyEvent.VK_X);

	// ����Ϊ��Ա���������󣩵Ķ���
	// �˴�����˵�(��TestJFrameDirect.java��һ��)
	JTextArea ta = new JTextArea();// �ı���

	JToolBar mtb = new JToolBar();

	TestJFrameExtends(String sTitle) {
		super(sTitle);

		// �ڣ���������������ֱ����Ӳ˵���JTextArea
		addMenus();
		addToolBar();

		// ��Ӵ�������(JScrollPane)���ı��༭��JTextArea
		JScrollPane sp = new JScrollPane(ta);
		// JScrollPane sp = new JScrollPane();
		add(sp);

		// �ۣ����ô��ڴ�С
		setSize(400, 300);
		// ����close��ť�Ĳ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ʹ��������ʾ��������ʾ
		centerWindow();

		// �ı䴰��ͼ��
		Toolkit tk = getToolkit(); // �õ�һ��Toolkit����
		Image icon = tk.getImage("online.gif"); // ��ȡͼ��  //img/open.png
		setIconImage(icon);
	}

	// ��Ӳ˵�
	private void addMenus() {
		setJMenuBar(mb);
		mFile.add(miNew);// �½�
		// ......
		mb.add(mFile);
	}

	private void addToolBar() {
		// ������
		Container c = getContentPane();
		c.add(BorderLayout.NORTH, mtb);

		mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// String icon = "E:\\Teaching\\Teaching.Attachments\\Java\\workspace\\JavaPrograming\\src\\img\\new.png";
		ImageIcon ii = new ImageIcon(ImageScaling.zoom(new_icon, .15));
		// ImageIcon ii = new ImageIcon(icon);
		FgButton newButton = new FgButton(
				ii,
				"�½��ļ�"
				); 
		
		FgButton openButton = new FgButton(new ImageIcon(ImageScaling.zoom(
				open_icon, .1)), "���ļ�");
		FgButton saveButton = new FgButton(new ImageIcon(ImageScaling.zoom(
				save_icon, .2)), "�����ļ�");
		
		// �����̳�MouseAdapter��
		newButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				 System.out.println("xxxx");
				// repaint();
			}
		});
		
		FgButton[] btn = { newButton, openButton, saveButton };

		for (int i = 0; i < btn.length; i++) {
			btn[i].setBorder(BorderFactory.createEmptyBorder());
			mtb.add(btn[i]);
		}
		// ���ò��ɸ���
		mtb.setFloatable(false);
	}

	// ���ھ���
	public void centerWindow() {
		// �����ʾ�����洰�ڵĴ�С
		Dimension dm = getToolkit().getScreenSize();

		// �ô��ھ�����ʾ
		setLocation((int) (dm.getWidth() - getWidth()) / 2,
				(int) (dm.getHeight() - getHeight()) / 2); 
	}

	public static void centerWindow(JFrame f) {
		// �����ʾ�����洰�ڵĴ�С
		Dimension dm = f.getToolkit().getScreenSize();

		// �ô��ھ�����ʾ
		f.setLocation((int) (dm.getWidth() - f.getWidth()) / 2,
				(int) (dm.getHeight() - f.getHeight()) / 2);
	}

	public static void main(String args[]) {
		// �٣��������ڶ���
		TestJFrameExtends frm = new TestJFrameExtends(
				"�����ҵ���һ��java���ڳ���");
		// �ܣ���ʾ����
		frm.setVisible(true);
	}
}
