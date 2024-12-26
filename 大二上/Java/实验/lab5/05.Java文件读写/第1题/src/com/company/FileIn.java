package com.company;
import java.util.*;
import java.io.*;
class Student implements Comparable{
    String id;
    String name;
    public int compareTo(Object o) {
        Student s=(Student)o;
        return this.id.compareTo(s.id);  //若是id是long，则可return this.id-s.id
    }
}
public class FileIn {
    public static void main(String args[]) {
        try {
            String File ="班级名单.txt";//文件读写注意根目录.后缀名
            String newFile ="班级名单_sorted.txt";
            FileInputStream reader=new FileInputStream(File);//字节流
            BufferedReader rf = new BufferedReader(new InputStreamReader(reader, "gb2312"));//读的时候用gb2312编码读
            BufferedWriter wf = new BufferedWriter(new FileWriter(newFile));//字符流
//输出到屏幕1
//            int b;
//            while ((b = rf.read()) != -1) {//用read()方法逐个字节读取
//                System.out.print((char) b);
//            }// 转换成char并显示
            Scanner in=new Scanner(System.in);
            ArrayList<Student> list=new ArrayList<Student>();
            int i=0;
            while (rf.ready()) {
                String line = rf.readLine(); //读取一行
                System.out.println(line);// 在屏幕上输出2
                Student stu=new Student();
                String[] s=line.split("\t");//line.split(" ")用空格运行不了
                stu.id=s[0];
                stu.name=s[1];
                list.add(stu);
                i++;
            }
            Collections.sort(list);
            Student t=new Student();
            for(int j=0;j<i;j++) {
                t=list.get(j);
                wf.write(t.id+" "+t.name);//写入文件
                wf.newLine();
                wf.flush(); //刷新该流的缓冲，即将该流输出到目的
            }
            reader.close();
            rf.close();
            wf.close();

            //输入学号，输出学生名字
            while(in.hasNext()){
                String n=in.next();
                System.out.println("查找的学生姓名:");
                for(int j=0;j<i;j++){
                    t=list.get(j);
                    if(t.id.equals(n)) System.out.println(t.name);
                }
            }

        } catch (IOException ie) {
            System.out.println(ie);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

