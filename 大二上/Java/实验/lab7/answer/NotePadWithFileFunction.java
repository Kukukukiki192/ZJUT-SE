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
 * �ҵ���һ��java���ڳ��� ͨ����JFrame�̳еõ��Զ���Ĵ����ࣺTestJFrameExtends
 */

public class NotePadWithFileFunction extends JFrame {
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
	
	DefaultFont df = new DefaultFont(8, "����");
    public static Color selectedColor = new Color(0); //��Ϊ A Color object is designed to be immutable

	NotePadWithFileFunction(String sTitle) {
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //��closing�¼��Ǳ߽ӹ�
		// ʹ��������ʾ��������ʾ
		centerWindow();
		
		
		exitConfirm();
		
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
	 * ��ӹ�����
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

	// ���ھ���
	public void centerWindow() {
		// �����ʾ�����洰�ڵĴ�С
		Dimension dm = getToolkit().getScreenSize();

		// �ô��ھ�����ʾ
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
				int r = JOptionPane.showConfirmDialog(null, "����Ҫ������", "������ʾ", JOptionPane.YES_NO_CANCEL_OPTION);
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
		// �٣��������ڶ���
		NotePadWithFileFunction frm = new NotePadWithFileFunction("���±�");
		// �ܣ���ʾ����
		frm.setVisible(true);
	}
}
