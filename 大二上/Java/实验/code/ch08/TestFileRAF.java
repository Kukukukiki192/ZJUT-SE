package cn.edu.zjut.java.ch08;

import java.io.IOException;
import java.io.RandomAccessFile;

public class TestFileRAF {
	public static void main(String args[]) {
		try {
			RandomAccessFile f = new RandomAccessFile("TestFileRAF.txt", "rw");//可读写
			int i;
			double d;
			// 写：向文件写入10个数据
			for (i = 0; i < 10; i++)
				f.writeDouble(Math.PI * i);
			f.seek(0);
			// 修改：对文件中第2个double数据改为0
			f.seek(Double.BYTES * 2);// 文件指针往前走16个字节(2个double数据)
			f.writeDouble(0);

			f.seek(0);// 文件指针回到文件首部

			// 读取：将全部数据读出并打印到屏幕中
			for (i = 0; i < 10; i++) {
				d = f.readDouble();
				System.out.println("[" + i + "]: " + d);
			}
			f.close();
		} catch (IOException e) {
			System.err.println("发生异常:" + e);
			e.printStackTrace();
		} 
	}
}
