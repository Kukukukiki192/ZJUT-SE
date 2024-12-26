package cn.edu.zjut.java.ch08;

/*将Student对象数据写入object.dat*/
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestWriteObject {
	public static void main(String args[]) {
		try {
			ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream(
					"object.dat"));
			Student s = new Student("张三", 2003001, 172);
			f.writeObject(s);
			s.output();
			f.close();
		} catch (Exception e) {
			System.err.println("发生异常:" + e);
			e.printStackTrace();
		}
	}
}

