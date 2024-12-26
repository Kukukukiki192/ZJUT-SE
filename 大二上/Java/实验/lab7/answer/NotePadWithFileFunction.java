package cn.edu.zjut.java.exp06;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.channels.NonWritableChannelException;
import java.util.WeakHashMap;

import javax.swing.*;
 

/**
 * 我的另一个java窗口程序， 通过从JFrame继承得到自定义的窗口类：TestJFrameExtends
 */

public class NotePadWithFileFunction extends JFrame {
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
	
	DefaultFont df = new DefaultFont(8, "宋体");
    public static Color selectedColor = new Color(0); //因为 A Color object is designed to be immutable

	NotePadWithFileFunction(String sTitle) {
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //由closing事件那边接管
		// 使窗口在显示屏居中显示
		centerWindow();
		
		
		exitConfirm();
		
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
		
		
		miNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ta.setText("");
				
			}
		});	
		
		miOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser fd=new JFileChooser();
				fd.showOpenDialog(null);
				File f=fd.getSelectedFile();
				//System.out.println(f.getName());
				
				if(f == null)
					return;

				String s = "";
				try {
					BufferedReader bw = new BufferedReader(new FileReader(f.getAbsolutePath()));
					
					String line = null;
					while((line = bw.readLine()) != null){
						s += line + "\n";
					}
					
				} catch (IOException e1) { 
					e1.printStackTrace();
				}				
				ta.setText(s);;
				
			}
		});
		
		
		miSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fd=new JFileChooser();
				fd.showSaveDialog(null);
				File f=fd.getSelectedFile();
				//System.out.println(f.getName());

				if(f == null)
					return;
				
				String s = ta.getText();
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(f.getAbsolutePath()));
					bw.write(s);
					bw.flush();
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		miFont.addActionListener(new FontActionListener(this));
		
		
		miQuit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
	}

	/**
	 * 添加工具栏
	 */
	private void addToolBar() {
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
		
		

		newButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				
			}
		});	
		
		
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fd=new JFileChooser();
				fd.showSaveDialog(null);
				File f=fd.getSelectedFile(); 

				if(f == null)
					return;
				String s = ta.getText();
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(f.getAbsolutePath()));
					bw.write(s);
					bw.flush();
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		openButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser fd=new JFileChooser();
				fd.showOpenDialog(null);
				File f=fd.getSelectedFile(); 
				

				if(f == null)
					return;
				String s = "";
				try {
					BufferedReader bw = new BufferedReader(new FileReader(f.getAbsolutePath()));
					
					String line = null;
					while((line = bw.readLine()) != null){
						s += line + "\n";
					}
					
				} catch (IOException e1) { 
					e1.printStackTrace();
				}				
				ta.setText(s);;
				
			}
		});
		
		
		
	}

	// 窗口居中
	public void centerWindow() {
		// 获得显示屏桌面窗口的大小
		Dimension dm = getToolkit().getScreenSize();

		// 让窗口居中显示
		setLocation((int) (dm.getWidth() - getWidth()) / 2,
				(int) (dm.getHeight() - getHeight()) / 2); 
	}

	public void exitConfirm(){
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				int r = JOptionPane.showConfirmDialog(null, "你需要保存吗？", "保存提示", JOptionPane.YES_NO_CANCEL_OPTION);
				System.out.println(r);
				if(r == JOptionPane.YES_OPTION){
					//save file
				}
				else if (r ==  JOptionPane.NO_OPTION){
					System.exit(0);
				}
				else if (r == JOptionPane.CANCEL_OPTION){
					//do nothing.
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	

	public static void main(String args[]) {
		// ①：创建窗口对象
		NotePadWithFileFunction frm = new NotePadWithFileFunction("记事本");
		// ④：显示窗口
		frm.setVisible(true);
	}
}
