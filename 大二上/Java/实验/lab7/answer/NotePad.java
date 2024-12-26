package cn.edu.zjut.java.exp06;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.WeakHashMap;

import javax.swing.*;
 

/**
 * �ҵ���һ��java���ڳ��� ͨ����JFrame�̳еõ��Զ���Ĵ����ࣺTestJFrameExtends
 */

public class NotePad extends JFrame {
	private static final long serialVersionUID = 1L;

	private final static String new_icon = "img/new.png";
	private final static String save_icon = "img/save.png";
	private final static String open_icon = "img/open.png";

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

	NotePad(String sTitle) {
		super(sTitle);

		// �ڣ���������������ֱ����Ӳ˵���JTextArea
		addMenus();
		addToolBar();

		// ��Ӵ�������(JScrollPane)���ı��༭��JTextArea
		JScrollPane sp = new JScrollPane(ta); 
		// JScrollPane sp = new JScrollPane();
		add(sp);

		// �ۣ����ô��ڴ�С
		setSize(800, 600);
		// ����close��ť�Ĳ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ʹ��������ʾ��������ʾ
		centerWindow();
		
		addContent(); 
		
	} 
	/**
	 * ��Ӳ˵�
	 */
	private void addMenus() {
		setJMenuBar(mb);
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.addSeparator();
		mFile.add(miFont);
		mFile.addSeparator();
		mFile.add(miQuit);
		mb.add(mFile); 
	}

	/**
	 * ��ӹ�����
	 */
	private void addToolBar() {
		// ������
		Container c = getContentPane();
		c.add(BorderLayout.NORTH, mtb);

		mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// String icon = "E:\\Teaching\\Teaching.Attachments\\Java\\workspace\\JavaPrograming\\src\\img\\new.png";
		//ImageIcon ii = new ImageIcon(getClass().getResource("new.png"));
		//ImageIcon ii = new(new ImageIcon(ImageScaling.zoom( new_icon, 1)
	
		 
		// ImageIcon ii = new ImageIcon(icon);
		FgButton newButton = new FgButton( new ImageIcon(ImageScaling.zoom(
				new_icon, 0.1)) ,  "�½��ļ�" ); 
		
		FgButton openButton = new FgButton(new ImageIcon(ImageScaling.zoom(
				open_icon, 0.1)), "���ļ�");
		FgButton saveButton = new FgButton(new ImageIcon(ImageScaling.zoom(
				save_icon, 0.2)), "�����ļ�");
		
		FgButton[] btn = { newButton, openButton, saveButton };

		for (int i = 0; i < btn.length; i++) {
			btn[i].setBorder(BorderFactory.createEmptyBorder());
			mtb.add(btn[i]);
		}
		// ���ò��ɸ���
		mtb.setFloatable(false);
	}
 
	/**
	 * ���ھ���
	 */
	public void centerWindow() {
		// �����ʾ�����洰�ڵĴ�С
		Dimension dm = getToolkit().getScreenSize();

		// �ô��ھ�����ʾ
		setLocation((int) (dm.getWidth() - getWidth()) / 2,
				(int) (dm.getHeight() - getHeight()) / 2); 
	}
	

	
	/**
	 * �������
	 */
	private void addContent(){ 
		String result = "";
		try {		

			BufferedReader reader = new BufferedReader( new FileReader("ѧ����Ϣencoded.txt"));
			String line = null;
			while((line = reader.readLine()) != null){
				result += URLDecoder.decode(line, "utf-8");
				result += "\n";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ta.setText(result); 
	}


	public static void main(String args[]) {
		// �٣��������ڶ���
		NotePad frm = new NotePad("���±�");
		// �ܣ���ʾ����
		frm.setVisible(true);
	}
}
