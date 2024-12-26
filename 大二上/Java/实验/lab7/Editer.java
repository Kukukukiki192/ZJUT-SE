package classwork;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.text.StyleConstants;

import classwork.FgButton;
import classwork.ImageScaling;

public class Editer extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final static String new_icon = "/Users/thorn/Desktop/java�ϻ�ʵ��/Java GUI-�ز�/img/new.png";
	private final static String save_icon = "/Users/thorn/Desktop/java�ϻ�ʵ��/Java GUI-�ز�/img/save.png";
	private final static String open_icon = "/Users/thorn/Desktop/java�ϻ�ʵ��/Java GUI-�ز�/img/open.png";

	JMenuBar mb = new JMenuBar();

	public JFileChooser filechooser = new JFileChooser();
	FgMenu file = new FgMenu("�ļ�(F) ", KeyEvent.VK_F);// �ļ�
	FgMenu format = new FgMenu("����(R)", KeyEvent.VK_R);// ��ʽ
	// JMenuItem format = new JMenuItem("����(R)", KeyEvent.VK_R);// ��ʽ
	JMenuItem newfile = new JMenuItem("�½�(N)", KeyEvent.VK_N);// �½�
	JMenuItem open = new JMenuItem("��(C)", KeyEvent.VK_O);// ��
	JMenuItem save = new JMenuItem("����(S)", KeyEvent.VK_S);// ����
	JMenuItem saveas = new JMenuItem("���Ϊ");// ���Ϊ
	JMenuItem font = new JMenuItem("��������ɫ");// ����
	JFileChooser fileDialog = new JFileChooser();
	// BufferedReader in;
	FileReader fileReader;
	BufferedWriter out;
	FileWriter fileWriter;
	int flag = 0;
	int flag1 = 0;
	File dir;
	String name;// �����ļ����½�����

	JComboBox<String> color = new JComboBox<String>();
	JComboBox<String> FFont = new JComboBox<String>();
	JComboBox<String> FontStyle = new JComboBox<String>();
	JComboBox<String> FontSize = new JComboBox<String>();// framefont�����
	JToolBar mtb = new JToolBar();
	JTextPane textPane = new JTextPane();
	JScrollPane scrollPane = new JScrollPane();

	public void framefont() {
		JFrame frm1 = new JFrame("������ɫ����");
		frm1.add(new Label("��ɫ��"));
		frm1.add(color);
		color.addActionListener(this);
		color.addItem("��");
		color.addItem("��");
		color.addItem("��");
		color.addItem("��");
		color.addItem("��");
		frm1.add(new Label("���壺"));
		frm1.add(FFont);
		frm1.add(new Label("��С��"));
		frm1.add(FontSize);
		frm1.add(new Label("��ʽ��"));
		frm1.add(FontStyle);
		frm1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		frm1.setBounds(10, 10, 500, 300);
		centerWindow(frm1);
		frm1.setVisible(true);
	}

	public void myframe() {
		JFrame frm = new JFrame("���±�");
		frm.setJMenuBar(mb);
		addToolBar();
		// frm.setLayout(new BorderLayout());
		frm.add(mtb, BorderLayout.NORTH);// add����ü���λ��
		// frm.add(mtb);��Ӱ����
		mb.add(file);
		mb.add(format);

		file.add(newfile);
		file.add(open);
		file.add(save);
		file.add(saveas);// �ļ�����ع���

		format.add(font);// ��ʽ����ع���
		frm.add(new Label("��������"));
		frm.add(FFont);
		frm.add(new Label("������"));
		frm.add(FontStyle);

		FontStyle.addItem("��ͨ");
		FontStyle.addItem("����");
		FontStyle.addItem("б��");
		FontStyle.addItem("��б��");

		frm.add(new Label("�����С"));
		frm.add(FontSize);
		InitFonts();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(textPane);
		frm.add(scrollPane);
		sizeWindowOnScreen(this, 0.6, 0.6);
		newfile.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		font.addActionListener(this);
		FFont.addActionListener(this);
		FontStyle.addActionListener(this);
		FontSize.addActionListener(this);

		frm.setBounds(10, 10, 800, 600);
		centerWindow(frm);
		frm.setVisible(true);
	}

	public void addToolBar() {
		// ������
		// JToolBar mtb = new JToolBar();
		// Container c = getContentPane();
		// c.add(BorderLayout.NORTH, mtb);
		mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		String icon = "E:\\Teaching\\Teaching.Attachments\\Java\\workspace\\JavaPrograming\\src\\img\\new.png";
		ImageIcon ii = new ImageIcon(ImageScaling.zoom(new_icon, .15));
		// ImageIcon ii = new ImageIcon(icon);
		FgButton newButton = new FgButton(ii, "�½��ļ�");
		FgButton openButton = new FgButton(new ImageIcon(ImageScaling.zoom(open_icon, .1)), "���ļ�");
		FgButton saveButton = new FgButton(new ImageIcon(ImageScaling.zoom(save_icon, .2)), "�����ļ�");

		// �����̳�MouseAdapter��

		newButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				newitem();
				repaint();// ����д������Ȼ�ڶ��λᱨ����Ҳ�ǿ�
			}
		});

		openButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				openitem();
				repaint();
			}
		});

		saveButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				saveitem();
				repaint();
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

	public void newitem() {
		int n = JOptionPane.showConfirmDialog(this, "��ȷ���ļ��Ƿ��ѱ��棬ȷ���Ƿ񱣴�", "ȷ�϶Ի���", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION)
			save();
		else if (n == JOptionPane.NO_OPTION)
			textPane.setText(null);
	}

	public void openitem() {
		int i = filechooser.showOpenDialog(Editer.this); // ��ʾ���ļ��Ի���
		if (i == JFileChooser.APPROVE_OPTION) // ����Ի����ѡ��
		{
			File f = filechooser.getSelectedFile(); // �õ�ѡ����ļ�
			dir = f.getParentFile();
			name = f.getName();
			try {
				FileInputStream is = new FileInputStream(f);
				textPane.read(is, "d");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		flag = 1;
	}

	public void saveitem() {
		if (flag == 0) {
			save();
		} else if (flag == 1) {
			try {
				File file = new File(dir, name);
				fileWriter = new FileWriter(file);
				out = new BufferedWriter(fileWriter);
				out.write(textPane.getText());
				out.flush();
			} catch (IOException exp) {
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if (e.getSource() == newfile) {
			newitem();
			// �տ�ʼ˼·���ͼƬ��ť��Ӧͬ����������������ֻ��Ҫдһ�Σ����ƺ�����ִ��
			// �����´������ط���Ҫͬһ��������ʱ�����������������
		}
		if (e.getSource() == open) {
			openitem();
		}
		if (e.getSource() == save) {
			saveitem();
		}
		if (e.getSource() == saveas) {
			save();
		}
		// ����ܷ� �����ҵĴ���
		if (e.getSource() == font) {
			framefont();
		}
		if (e.getSource() == color) {
			if (color.getSelectedItem() == "��")
				textPane.setForeground(Color.RED);
			if (color.getSelectedItem() == "��")
				textPane.setForeground(Color.YELLOW);
			if (color.getSelectedItem() == "��")
				textPane.setForeground(Color.BLUE);
			if (color.getSelectedItem() == "��")
				textPane.setForeground(Color.GREEN);
			if (color.getSelectedItem() == "��")
				textPane.setForeground(Color.BLACK);
		}
		if (e.getSource() == FFont || e.getSource() == FontStyle || e.getSource() == FontSize) {
			String size = (String) FontSize.getSelectedItem();
			if (FontStyle.getSelectedItem() == "��ͨ")
				textPane.setFont(new Font((String) FFont.getSelectedItem(), Font.PLAIN, Integer.valueOf(size)));
			if (FontStyle.getSelectedItem() == "����")
				textPane.setFont(new Font((String) FFont.getSelectedItem(), Font.BOLD, Integer.valueOf(size)));
			if (FontStyle.getSelectedItem() == "б��")
				textPane.setFont(new Font((String) FFont.getSelectedItem(), Font.ITALIC, Integer.valueOf(size)));
			if (FontStyle.getSelectedItem() == "��б��")
				textPane.setFont(
						new Font((String) FFont.getSelectedItem(), Font.BOLD + Font.ITALIC, Integer.valueOf(size)));
		}

	}

	private void InitFonts() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontList = ge.getAvailableFontFamilyNames();
		int i;
		for (i = 0; i < fontList.length; i++) {
			FFont.addItem(/* String .valueOf(i)+" | "+ */fontList[i]);
		}
		// Font.setSelectedItem(30);

		for (i = 9; i <= 72; i++) {
			FontSize.addItem(new Integer(i).toString());
		}
		// FontSize.setSelectedItem(3);
	}

	private void sizeWindowOnScreen(Editer Editer, double widthRate, double heightRate) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		Editer.setSize(new Dimension((int) (screenSize.width * widthRate), (int) (screenSize.height * heightRate)));
	}

	public void save() {
		int state = fileDialog.showSaveDialog(this);
		if (state == JFileChooser.APPROVE_OPTION) {
			try {
				dir = fileDialog.getCurrentDirectory();
				name = fileDialog.getSelectedFile().getName();
				File file = new File(dir, name);
				fileWriter = new FileWriter(file);
				out = new BufferedWriter(fileWriter);
				out.write(textPane.getText());
				out.close();
				fileWriter.close();
				flag = 1;
			}

			catch (IOException exp) {
			}
		}

	}

	public void centerWindow(JFrame frame) {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - getHeight() / 2;
		frame.setLocation(x, y);

	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Editer f = new Editer();
		f.myframe();
	}

}

@SuppressWarnings("serial")
class FgMenu extends JMenu {
	public FgMenu(String label) {
		super(label);
	}

	public FgMenu(String label, int nAccelerator) {
		super(label);
		setMnemonic(nAccelerator);
	}
}
