package cn.edu.zjut.java.ch08;

/*从object.dat读出Student对象数据*/
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestReadObject {
	public static void main(String args[]) {
		try {
			ObjectInputStream f = new ObjectInputStream(new FileInputStream(
					"object.dat"));
			Student s = (Student) (f.readObject());
			s.output();
			f.close();
		} catch (Exception e) {
			System.err.println("发生异常:" + e);
			e.printStackTrace();
		}
	}
}
