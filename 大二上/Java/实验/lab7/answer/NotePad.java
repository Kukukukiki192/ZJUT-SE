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
 * 我的另一个java窗口程序， 通过从JFrame继承得到自定义的窗口类：TestJFrameExtends
 */

public class NotePad extends JFrame {
	private static final long serialVersionUID = 1L;

	private final static String new_icon = "img/new.png";
	private final static String save_icon = "img/save.png";
	private final static String open_icon = "img/open.png";

	static JMenuBar mb = new JMenuBar();// 菜单栏
	static FgMenu mFile = new FgMenu("文件(F)", KeyEvent.VK_F);// "文件"菜单
	static JMenuItem miNew = new JMenuItem("新建(N)", KeyEvent.VK_N),
					miOpen = new JMenuItem("打开(O)...", KeyEvent.VK_O),
					miSave = new JMenuItem("保存(S)", KeyEvent.VK_S),
					miFont = new JMenuItem("字体与颜色(F)...", KeyEvent.VK_F),
					miQuit = new JMenuItem("退出(X)", KeyEvent.VK_X);

	// 以下为成员变量（对象）的定义
	// 此处定义菜单(与TestJFrameDirect.java中一样)
	JTextArea ta = new JTextArea();// 文本框

	JToolBar mtb = new JToolBar();

	NotePad(String sTitle) {
		super(sTitle);

		// ②：添加组件。本例中直接添加菜单与JTextArea
		addMenus();
		addToolBar();

		// 添加带滚动条(JScrollPane)的文本编辑框JTextArea
		JScrollPane sp = new JScrollPane(ta); 
		// JScrollPane sp = new JScrollPane();
		add(sp);

		// ③：设置窗口大小
		setSize(800, 600);
		// 设置close按钮的操作
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 使窗口在显示屏居中显示
		centerWindow();
		
		addContent(); 
		
	} 
	/**
	 * 添加菜单
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
	 * 添加工具栏
	 */
	private void addToolBar() {
		// 工具条
		Container c = getContentPane();
		c.add(BorderLayout.NORTH, mtb);

		mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// String icon = "E:\\Teaching\\Teaching.Attachments\\Java\\workspace\\JavaPrograming\\src\\img\\new.png";
		//ImageIcon ii = new ImageIcon(getClass().getResource("new.png"));
		//ImageIcon ii = new(new ImageIcon(ImageScaling.zoom( new_icon, 1)
	
		 
		// ImageIcon ii = new ImageIcon(icon);
		FgButton newButton = new FgButton( new ImageIcon(ImageScaling.zoom(
				new_icon, 0.1)) ,  "新建文件" ); 
		
		FgButton openButton = new FgButton(new ImageIcon(ImageScaling.zoom(
				open_icon, 0.1)), "打开文件");
		FgButton saveButton = new FgButton(new ImageIcon(ImageScaling.zoom(
				save_icon, 0.2)), "保存文件");
		
		FgButton[] btn = { newButton, openButton, saveButton };

		for (int i = 0; i < btn.length; i++) {
			btn[i].setBorder(BorderFactory.createEmptyBorder());
			mtb.add(btn[i]);
		}
		// 设置不可浮动
		mtb.setFloatable(false);
	}
 
	/**
	 * 窗口居中
	 */
	public void centerWindow() {
		// 获得显示屏桌面窗口的大小
		Dimension dm = getToolkit().getScreenSize();

		// 让窗口居中显示
		setLocation((int) (dm.getWidth() - getWidth()) / 2,
				(int) (dm.getHeight() - getHeight()) / 2); 
	}
	

	
	/**
	 * 添加内容
	 */
	private void addContent(){ 
		String result = "";
		try {		

			BufferedReader reader = new BufferedReader( new FileReader("学生信息encoded.txt"));
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
		// ①：创建窗口对象
		NotePad frm = new NotePad("记事本");
		// ④：显示窗口
		frm.setVisible(true);
	}
}
