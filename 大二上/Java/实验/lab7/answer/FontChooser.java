package cn.edu.zjut.java.exp06;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class FontChooser extends JDialog {

	JComboBox cbxFont = new JComboBox();
	JComboBox cbxFontSize = new JComboBox();// �����С

	JButton okButtion = new JButton("ȷ��");
	JButton cancelButtion = new JButton("ȡ��");
	
 

	String tmpFont = "����";
	int tmpFontSize = 8;
	
	DefaultFont df = new DefaultFont(tmpFontSize, tmpFont);
    
   
	
	FontChooser(JFrame parent, String sTitle, DefaultFont df) {
		this(parent, sTitle);
		this.df = df;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	
	
	FontChooser(JFrame parent, String sTitle) {
		super(parent, sTitle, true);
		
		
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));

		c.add(new JLabel("�������ƣ�"));
		c.add(cbxFont);
		c.add(new JLabel("�����С��"));
		c.add(cbxFontSize);
		c.add(cancelButtion);
		c.add(okButtion);
		
		
		JPanel colorPanel = new ColorChooserDemo();
		c.add(colorPanel);

		// ��ʼ���������С������
		InitFonts();

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		centerWindow();
	}

	// ��ʼ�������
	private void InitFonts() {
		// ���ϵͳ����������
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontList = ge.getAvailableFontFamilyNames();
		int i;

		// �����������
		for (i = 0; i < fontList.length; i++)
			cbxFont.addItem(fontList[i]);

		cbxFont.setSelectedIndex(231);// ѡ��indexΪ231����
		// ��������С
		for (i = 9; i <= 72; i++)
			cbxFontSize.addItem(new Integer(i).toString());
		cbxFontSize.setSelectedIndex(3);// ѡ��indexΪ3����

		
		
		cbxFont.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED)
					tmpFont = ((String)e.getItem());
			}
		});
		
		cbxFontSize.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED)
					tmpFontSize = Integer.parseInt(((String)e.getItem()));
			}
		});

		okButtion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(df.font);
//				System.out.println(df.fontSize);
				
				df.font =   ((String)cbxFont.getSelectedItem());
				df.fontSize = Integer.parseInt(((String)cbxFontSize.getSelectedItem()));
				
				setVisible(false); 
				
				System.out.println("color: " + NotePadWithFileFunction.selectedColor);
			}
		});
		
		cancelButtion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		
		
		
	}
	public void centerWindow() {
		// �����ʾ�����洰�ڵĴ�С
		Dimension dm = getToolkit().getScreenSize();

		// �ô��ھ�����ʾ
		setLocation((int) (dm.getWidth() - getWidth()) / 2,
				(int) (dm.getHeight() - getHeight()) / 2); 
	}
	
	public static void main(String args[]) {
		FontChooser frm = new FontChooser(null, "JFrame with JComboBox");
		frm.setVisible(true);
	}
}
