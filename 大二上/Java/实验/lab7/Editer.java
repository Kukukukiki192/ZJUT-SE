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
	private final static String new_icon = "/Users/thorn/Desktop/java上机实验/Java GUI-素材/img/new.png";
	private final static String save_icon = "/Users/thorn/Desktop/java上机实验/Java GUI-素材/img/save.png";
	private final static String open_icon = "/Users/thorn/Desktop/java上机实验/Java GUI-素材/img/open.png";

	JMenuBar mb = new JMenuBar();

	public JFileChooser filechooser = new JFileChooser();
	FgMenu file = new FgMenu("文件(F) ", KeyEvent.VK_F);// 文件
	FgMenu format = new FgMenu("字体(R)", KeyEvent.VK_R);// 格式
	// JMenuItem format = new JMenuItem("字体(R)", KeyEvent.VK_R);// 格式
	JMenuItem newfile = new JMenuItem("新建(N)", KeyEvent.VK_N);// 新建
	JMenuItem open = new JMenuItem("打开(C)", KeyEvent.VK_O);// 打开
	JMenuItem save = new JMenuItem("保存(S)", KeyEvent.VK_S);// 保存
	JMenuItem saveas = new JMenuItem("另存为");// 另存为
	JMenuItem font = new JMenuItem("字体与颜色");// 字体
	JFileChooser fileDialog = new JFileChooser();
	// BufferedReader in;
	FileReader fileReader;
	BufferedWriter out;
	FileWriter fileWriter;
	int flag = 0;
	int flag1 = 0;
	File dir;
	String name;// 用于文件的新建保存

	JComboBox<String> color = new JComboBox<String>();
	JComboBox<String> FFont = new JComboBox<String>();
	JComboBox<String> FontStyle = new JComboBox<String>();
	JComboBox<String> FontSize = new JComboBox<String>();// framefont的组件
	JToolBar mtb = new JToolBar();
	JTextPane textPane = new JTextPane();
	JScrollPane scrollPane = new JScrollPane();

	public void framefont() {
		JFrame frm1 = new JFrame("文字颜色调节");
		frm1.add(new Label("颜色："));
		frm1.add(color);
		color.addActionListener(this);
		color.addItem("黑");
		color.addItem("黄");
		color.addItem("蓝");
		color.addItem("绿");
		color.addItem("红");
		frm1.add(new Label("字体："));
		frm1.add(FFont);
		frm1.add(new Label("大小："));
		frm1.add(FontSize);
		frm1.add(new Label("样式："));
		frm1.add(FontStyle);
		frm1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		frm1.setBounds(10, 10, 500, 300);
		centerWindow(frm1);
		frm1.setVisible(true);
	}

	public void myframe() {
		JFrame frm = new JFrame("记事本");
		frm.setJMenuBar(mb);
		addToolBar();
		// frm.setLayout(new BorderLayout());
		frm.add(mtb, BorderLayout.NORTH);// add里最好加上位置
		// frm.add(mtb);大坑啊大坑
		mb.add(file);
		mb.add(format);

		file.add(newfile);
		file.add(open);
		file.add(save);
		file.add(saveas);// 文件的相关功能

		format.add(font);// 格式的相关功能
		frm.add(new Label("字体名称"));
		frm.add(FFont);
		frm.add(new Label("字体风格"));
		frm.add(FontStyle);

		FontStyle.addItem("普通");
		FontStyle.addItem("粗体");
		FontStyle.addItem("斜体");
		FontStyle.addItem("粗斜体");

		frm.add(new Label("字体大小"));
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
		// 工具条
		// JToolBar mtb = new JToolBar();
		// Container c = getContentPane();
		// c.add(BorderLayout.NORTH, mtb);
		mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		String icon = "E:\\Teaching\\Teaching.Attachments\\Java\\workspace\\JavaPrograming\\src\\img\\new.png";
		ImageIcon ii = new ImageIcon(ImageScaling.zoom(new_icon, .15));
		// ImageIcon ii = new ImageIcon(icon);
		FgButton newButton = new FgButton(ii, "新建文件");
		FgButton openButton = new FgButton(new ImageIcon(ImageScaling.zoom(open_icon, .1)), "打开文件");
		FgButton saveButton = new FgButton(new ImageIcon(ImageScaling.zoom(save_icon, .2)), "保存文件");

		// 匿名继承MouseAdapter类

		newButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				newitem();
				repaint();// 必须写！！不然第二次会报错！！也是坑
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
		// 设置不可浮动
		mtb.setFloatable(false);
	}

	public void newitem() {
		int n = JOptionPane.showConfirmDialog(this, "请确认文件是否已保存，确认是否保存", "确认对话框", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION)
			save();
		else if (n == JOptionPane.NO_OPTION)
			textPane.setText(null);
	}

	public void openitem() {
		int i = filechooser.showOpenDialog(Editer.this); // 显示打开文件对话框
		if (i == JFileChooser.APPROVE_OPTION) // 点击对话框打开选项
		{
			File f = filechooser.getSelectedFile(); // 得到选择的文件
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
		// TODO 自动生成的方法存根
		if (e.getSource() == newfile) {
			newitem();
			// 刚开始思路想把图片按钮响应同步过来这样处理方法只需要写一次，但似乎不好执行
			// 所以下次两个地方需要同一个方法的时候可以拎出来方便调用
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
		// 字体很烦 网上找的代码
		if (e.getSource() == font) {
			framefont();
		}
		if (e.getSource() == color) {
			if (color.getSelectedItem() == "红")
				textPane.setForeground(Color.RED);
			if (color.getSelectedItem() == "黄")
				textPane.setForeground(Color.YELLOW);
			if (color.getSelectedItem() == "蓝")
				textPane.setForeground(Color.BLUE);
			if (color.getSelectedItem() == "绿")
				textPane.setForeground(Color.GREEN);
			if (color.getSelectedItem() == "黑")
				textPane.setForeground(Color.BLACK);
		}
		if (e.getSource() == FFont || e.getSource() == FontStyle || e.getSource() == FontSize) {
			String size = (String) FontSize.getSelectedItem();
			if (FontStyle.getSelectedItem() == "普通")
				textPane.setFont(new Font((String) FFont.getSelectedItem(), Font.PLAIN, Integer.valueOf(size)));
			if (FontStyle.getSelectedItem() == "粗体")
				textPane.setFont(new Font((String) FFont.getSelectedItem(), Font.BOLD, Integer.valueOf(size)));
			if (FontStyle.getSelectedItem() == "斜体")
				textPane.setFont(new Font((String) FFont.getSelectedItem(), Font.ITALIC, Integer.valueOf(size)));
			if (FontStyle.getSelectedItem() == "粗斜体")
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
		// TODO 自动生成的方法存根
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
