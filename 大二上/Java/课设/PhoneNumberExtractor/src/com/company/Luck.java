package com.company;
import java.io.IOException;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/*  一、大型实验的内容
    开发一个幸运观众手机号码抽取的图形用户界面程序,要求可设定获奖主题、获奖等级和人数,
    可录入观众姓名、手机号存入文本文件中（每行放一个观众姓名和手机号）.
    启动开始后能随机抽取存在文本文件中的若干个观众手机号码,显示时隐藏最后两位号码,
    并将获奖主题、获奖等级和获奖名单、手机号、获奖时间等保存在获奖的文本文件中,并可查询历史抽奖情况  */

/** Math类的random()方法可生成[0,1)之间的随机浮点数
    int x=(int)(Math.random()*10);  //生成[0,9]之间的随机整数
    int t=m+(int)(Math.random()*(n+1-m)); //生成[m,n]的随机整数   */

class FgMenu extends JMenu {
    public FgMenu(String label) {
        super(label);
    }
    public FgMenu(String label, int nAccelerator) {
        super(label);
        setMnemonic(nAccelerator);//设置快捷键
    }
}
public class Luck extends JFrame implements Runnable {
    JLabel jtheme,jnum, jtype,name,phonenumber; //标签-主题,人数 奖项,观众姓名 手机号
    JComboBox num, prize;//下拉框-人数 奖项
    JTextField themetxt;
    JTextField[] text = new JTextField[10];//单行文本框-设置获奖人数最多10个
    JButton enter,start1,history,start, end,restart,save;//按钮-录入 启动 历史,开始 结束,重置 保存

    int i,number = 4;//number为选择的获奖人数(默认人数为5 则默认人数下拉框索引为4的项)
    boolean isrun = false;//线程运行指令
    String fname = "infor.txt",fname1="history.txt";
    FileWriter f;
    Vector<String> v = new Vector<String>();//存储观众信息

    Calendar c ;
    SimpleDateFormat cc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获奖时间

    Luck(String s) {
        super(s);
        initComponents();
    }
    //主界面初始化及监听事件
    public void initComponents(){

        setBounds(500,170,320,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //窗口
        //3个按钮
        JPanel pan=new JPanel();
        pan.setLayout(new FlowLayout());//流式布局
        enter=new JButton("录入");
        start1=new JButton("启动");
        history=new JButton("历史");
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                entering(); //打开录入信息界面
            }
        });
        start1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start1(); //打开抽奖界面
            }
        });
        history.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showhistory();//打开历史记录界面
            }
        });
        pan.add(enter);
        pan.add(start1);
        pan.add(history);

        add(pan);
        setVisible(true);
    }
    //抽奖界面初始化及监听事件
    public void start1() {

        JFrame frm=new JFrame("幸运观众手机号码抽取器");
        frm.setBounds(500,170,300,450);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container jfrm = frm.getContentPane();//获取窗口面板     //窗口
        //面板-上
        JPanel up1=new JPanel();        //获奖主题
        up1.setLayout(new FlowLayout());
        jtheme = new JLabel("获奖主题:");
        themetxt = new JTextField(15);
        themetxt.setEditable(true);
        themetxt.setHorizontalAlignment(JTextField.LEFT);
        up1.add(jtheme);
        up1.add(themetxt);

        JPanel up2 = new JPanel();      //奖项 人数
        up2.setLayout(new FlowLayout());
        jtype = new JLabel("奖项:");
        jnum = new JLabel("人数:");
        String[] strtype = {"一等奖", "二等奖", "三等奖"};
        prize = new JComboBox(strtype);
        prize.setSelectedIndex(0);//默认奖项为一等奖 (选择索引2处的项 0为第1项 -1指没做出选择)
        prize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isrun = false;
                start.setEnabled(true);
                end.setEnabled(false);
                for (i = 0; i < 10; i++) {
                    text[i].setText("");//初始化10个空文本框
                }
            }
        });
        String[] str = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        num = new JComboBox(str);
        num.setSelectedIndex(4);//默认获奖人数为5人 (选择索引5处的项)
        num.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == num) {
                    isrun = false;
                    start.setEnabled(true);
                    end.setEnabled(false);
                    restart.setEnabled(false);
                    save.setEnabled(false);
                    number = num.getSelectedIndex();//number-获奖人数
                    for (i = 0; i < 10; i++) {
                        text[i].setEditable(true);
                        text[i].setText("");
                    }
                    if (number != 10) {
                        for (i = number + 1; i < 10; i++) {
                            text[i].setEditable(false);
                        }
                    }
                }
            }
        });
        up2.add(jtype);//奖项标签
        up2.add(prize);//奖项下拉框
        up2.add(jnum);//人数标签
        up2.add(num);//人数下拉框

        JPanel up3 = new JPanel();
        up3.setLayout(new GridLayout(1,2));
        phonenumber= new JLabel("手机号");
        name= new JLabel("观众姓名");
        phonenumber.setHorizontalAlignment(JTextField.CENTER);
        name.setHorizontalAlignment(JTextField.CENTER);
        up3.add(phonenumber);
        up3.add(name);

        JPanel jup = new JPanel();
        jup.setLayout(new GridLayout(3,1,20,0));
        jup.add(up1);
        jup.add(up2);
        jup.add(up3);

        //面板-中
        JPanel jtemp = new JPanel();        //10个单行文本框
        jtemp.setLayout(new BorderLayout());
        JPanel j1 = new JPanel();
        j1.add(new JLabel(" "));
        JPanel j2 = new JPanel();
        j2.add(new JLabel(" "));
        JPanel jcenter = new JPanel();
        jcenter.setLayout(new GridLayout(10, 1, 20, 0));
        for (i = 0; i < 10; i++) {
            text[i] = new JTextField("");
            text[i].setHorizontalAlignment(JTextField.LEFT);
            jcenter.add(text[i]);
        }
        for (i = number + 1; i < 10; i++) {
            text[i].setEditable(false);//>number的文本框不可编辑
        }
        jtemp.add("Center", jcenter);//BorderLayout.CENTER
        jtemp.add("West", j1);
        jtemp.add("East", j2);
        //面板-下
        JPanel jdown = new JPanel(),jdown1 = new JPanel(),jdown2 = new JPanel();    //4个按钮
        jdown.setLayout(new GridLayout(2,1,20,0));
        jdown1.setLayout(new FlowLayout());
        jdown2.setLayout(new FlowLayout());
        start = new JButton("开始");
        end = new JButton("结束");
        restart = new JButton("重置");
        save=new JButton("保存");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isrun = true;
                start.setEnabled(false);
                end.setEnabled(true);
                restart.setEnabled(false);
                save.setEnabled(false);
            }
        });
        end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isrun = false;
                start.setEnabled(true);
                end.setEnabled(false);
                restart.setEnabled(true);
                save.setEnabled(true);
                c= Calendar.getInstance();
            }
        });
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restart.setEnabled(false);
                save.setEnabled(false);
                for (i = 0; i <= number; i++) {
                    text[i].setEditable(true);
                    text[i].setText("");
                }
            }
        });
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                save.setEnabled(false);
                fout();//保存
                freshen();//刷新抽奖观众信息 将获奖观众从vector中删除，避免再次抽奖时重复
            }
        });
        end.setEnabled(false);
        restart.setEnabled(false);
        save.setEnabled(false);
        jdown1.add(start);
        jdown1.add(end);
        jdown2.add(restart);
        jdown2.add(save);
        jdown.add(jdown1);
        jdown.add(jdown2);
        //合并面板
        jfrm.setLayout(new BorderLayout());
        jfrm.add("North", jup);
        jfrm.add("Center", jtemp);
        jfrm.add("South", jdown);
        fin();
        frm.setAlwaysOnTop(true);
        frm.setVisible(true);
    }
    //处理从文件读入的数据
    public String texthand(String a) {
        String[] s=a.split(" ");
        String re=s[0].substring(0,9)+"**                               "+s[1];
        return re;
    }
    //将文件中信息读入vector
    public void fin() {
        v.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String s = br.readLine();
            while (s != null) {
                v.add(texthand(s));
                s = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //保存信息至文件
    public void fout(){
        try {
            f = new FileWriter(fname1, true);//true追加
            f.write("获奖主题:"+themetxt.getText()+"\n"
                        + "获奖等级:"+prize.getSelectedItem()+"\n"
                        + "获奖时间:"+cc.format(c.getTime())+"\n"
                        + "获奖名单:"+"\n");
            i=0;
            while (i<=number) {
                f.write(text[i++].getText()+"\n");
            }
            f.write("\n"+"\n");
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //刷新vector中的观众信息
    public void freshen(){
        for(i=0;i<=number;i++){
            for(int j=0;j<v.size();j++){
                if(v.get(j).equals(text[i].getText())) {
                    v.remove(j); break;
                }
            }
        }
    }
    //录入信息
    public void entering(){
        JFrame frm=new JFrame("录入观众信息");
        frm.setBounds(550,170,300,300);
        JTextArea ta=new JTextArea();
        JScrollPane jsp = new JScrollPane(ta);
        frm.add(jsp);
        //分别设置水平和垂直滚动条自动出现
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JMenuBar mb = new JMenuBar();
        FgMenu file = new FgMenu("文件(F) ", KeyEvent.VK_F);
        JMenuItem newfile = new JMenuItem("新建(N)", KeyEvent.VK_N),
                     save = new JMenuItem("保存(S)", KeyEvent.VK_S);
        file.add(newfile);
        file.add(save);
        mb.add(file);
        frm.setJMenuBar(mb);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setAlwaysOnTop(true);
        frm.setVisible(true);
        newfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ta.setText(null);
            }
        });
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                write(ta); fin();
            }
        });
    }
    //显示获奖观众历史记录
    public void showhistory(){
        JFrame frm = new JFrame("历史抽奖记录");
        frm.setBounds(550,170,300,300);
        JTextArea ta=new JTextArea();
        ta.setEditable(false);
        JScrollPane jsp = new JScrollPane(ta);
        frm.add(jsp);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setAlwaysOnTop(true);
        frm.setVisible(true);
        read(ta);//读取历史记录
    }
    //读取历史记录
    public void read(JTextArea ta){
        String result = "";
        try {
            BufferedReader br = new BufferedReader( new FileReader(fname1));
            String s = br.readLine();
            while (s != null) {
                result+=s+"\n";
                s = br.readLine();
            }   br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ta.setText(result);
    }
    //录入保存
    public void write(JTextArea ta){
            try {
                f = new FileWriter(fname, true);//true-追加
                f.write("\n"+ta.getText());
                f.close();
                //下面这个方法用了append但还是追加不了
//                BufferedWriter bw = new BufferedWriter(new FileWriter(textname));
//                bw.append(ta.getText());
//                bw.flush();//关键!!
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    //线程运行
    public void run(){
        int k=0;
        while(true){
            if(isrun){//isrun为线程运行指令 该指令为true时开始运行直到为false时停下
                int m=50+(int)(Math.random()*100);//生成[50,149]的随机整数
                try{
                    Thread.sleep(m);// 基于共享资源实现的话，加入sleep会乱序显示
                    //有时在同一个框中显示两条信息,所以在run()中使线程随机sleep
                } catch(Exception e){
                    e.printStackTrace();
                }
                for(i=0;i<=number;i++){
                    if(k>=v.size()){
                        k = 0;
                    }
                    if(i!=10) text[i].setText(v.get(k)); //在text[i]中随机显示手机号码
                    k+=4;
                }
            }
        }
    }
    //3个线程共享资源
    static public void test(){
        Luck t = new Luck("幸运观众手机号码抽取器");
        Thread  t1 = new Thread(t),
                t2 = new Thread(t),
                t3 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
        test();
    }
}
