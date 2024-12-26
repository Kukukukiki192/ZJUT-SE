package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

class FgMenu extends JMenu {
    public FgMenu(String label) {
        super(label);
    }

    public FgMenu(String label, int nAccelerator) {
        super(label);
        setMnemonic(nAccelerator);//设置快捷键
    }
}

public class NotePad extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final static String new_icon = "img/new.png",save_icon = "img/save.png",open_icon = "img/open.png";
    JMenuBar mb = new JMenuBar();//菜单栏
    JToolBar mtb = new JToolBar();//工具栏
    JTextPane textPane = new JTextPane();//文本框
    JScrollPane scrollPane = new JScrollPane();//滚动条
    JFileChooser filechooser = new JFileChooser(),fileDialog = new JFileChooser();
    FgMenu file = new FgMenu("文件(F) ", KeyEvent.VK_F),
           format = new FgMenu("字体(R)", KeyEvent.VK_R);// 格式
    JMenuItem   newfile = new JMenuItem("新建(N)", KeyEvent.VK_N),
                open = new JMenuItem("打开(C)", KeyEvent.VK_O),
                save = new JMenuItem("保存(S)", KeyEvent.VK_S),
                saveas = new JMenuItem("另存为"),
                font = new JMenuItem("字体与颜色");
    BufferedWriter out;
    FileWriter fileWriter;
    int flag = 0;
    File dir;
    String name;// 用于文件的新建保存

    JComboBox<String>   color = new JComboBox<String>(),
                        FFont = new JComboBox<String>(),
                        FontStyle = new JComboBox<String>(),
                        FontSize = new JComboBox<String>();// framefont的组件

    void framefont() {//文字颜色调节菜单
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

    void frame() {//窗口菜单
        JFrame frm = new JFrame("记事本");
        frm.setJMenuBar(mb);
        addToolBar();
        frm.add(mtb, BorderLayout.NORTH);
        mb.add(file);
        mb.add(format);

        file.add(newfile);
        file.add(open);
        file.add(save);
        file.add(saveas);

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

    void addToolBar() {
        // 工具条
        // JToolBar mtb = new JToolBar();
        // Container c = getContentPane();
        // c.add(BorderLayout.NORTH, mtb);
        mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
        // ImageIcon image = new ImageIcon(icon);无缩放
        ImageIcon New = new ImageIcon(ImageScaling.zoom(new_icon, 0.1)),//对图标缩放
                 Open = new ImageIcon(ImageScaling.zoom(open_icon, 0.1)),
                 Save = new ImageIcon(ImageScaling.zoom(save_icon, 0.18));
        FgButton newButton = new FgButton(New,  "新建文件"),
                openButton = new FgButton(Open, "打开文件"),
                saveButton = new FgButton(Save, "保存文件");

        // 匿名继承MouseAdapter类
        newButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                newitem();
                repaint();
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

    void newitem() {
        int t = JOptionPane.showConfirmDialog(this, // 显示新建文件对话框
                "是否保存?", "确认对话框", JOptionPane.YES_NO_OPTION);
        if (t == JOptionPane.YES_OPTION)
            save();
        else if (t == JOptionPane.NO_OPTION)
            textPane.setText(null);
    }

    void openitem() {
        int t = filechooser.showOpenDialog(NotePad.this); // 显示打开文件对话框
        if (t == JFileChooser.APPROVE_OPTION) // 点击对话框打开选项
        {
            File f = filechooser.getSelectedFile(); // 得到选择的文件
            dir = f.getParentFile();
            name = f.getName();
            try {
                FileInputStream rf = new FileInputStream(f);
                textPane.read(rf, "d");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        flag = 1;
    }

    void saveitem() {
        if (flag == 0) {
            save();
        } else if (flag == 1) {
            try {
                File file = new File(dir, name);
                fileWriter = new FileWriter(file);
                out = new BufferedWriter(fileWriter);
                out.write(textPane.getText());
                out.flush();//关键!!
            } catch (IOException exp) {
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newfile) {
            newitem();
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
                textPane.setFont(new Font((String) FFont.getSelectedItem(),
                        Font.BOLD + Font.ITALIC, Integer.valueOf(size)));
        }

    }

    private void InitFonts() {//初始化字体框
        //获得系统的字体数组
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontList = ge.getAvailableFontFamilyNames();
        int i;
        //添加字体名称
        for (i = 0; i < fontList.length; i++) {
            FFont.addItem(fontList[i]);//将系统字体名称加到下拉框
        }
        //添加字体大小
        for (i = 9; i <= 72; i++) {
            FontSize.addItem(new Integer(i).toString());//字体大小下拉框
        }
    }

    private void sizeWindowOnScreen(NotePad NotePad, double widthRate, double heightRate) {
        //获得显示屏桌面窗口的大小
        Toolkit tk=getToolkit();
        Dimension dm=tk.getScreenSize();
        //设置窗口大小缩放比例
        NotePad.setSize(new Dimension((int) (dm.width * widthRate), (int) (dm.height * heightRate)));
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
        //获得显示屏桌面窗口的大小
        Toolkit tk=getToolkit();
        Dimension dm=tk.getScreenSize();
        //让窗口居中显示
        frame.setLocation( (int) dm.getWidth() / 2 - getWidth() / 2,(int) dm.getHeight() / 2 - getHeight() / 2);
    }

    public static void main(String[] args) {
        NotePad f = new NotePad();//创建窗口对象
        f.frame();//显示窗口
    }
}