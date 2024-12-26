package cn.edu.zjut.java.ch08;

import java.io.File;
import java.io.IOException;

public class Eg01_FilePRO {

	public static void main(String[] args) throws IOException {
		

		File f = new File("src/cn/edu/zjut/java/ch08/fFile");
		//f.createNewFile();
		
		
		File d = new File("dFile");		
		//File d = new File("src/cn/edu/zjut/java/ch08/Eg01_FilePro.java");
		//d.createNewFile();
		
		

		System.out.println("f.getName=" + f.getName());
		System.out.println("f.getPath=" + f.getPath());
		
		System.out.println("f.getAbsolutePath=" + f.getAbsolutePath());
		System.out.println("f.getParent=" + f.getParent());
		System.out.println("f.length=" + f.length());

		System.out.println("d.getName=" + d.getName());
		System.out.println("d.getPath=" + d.getPath());
		System.out.println("d.getAbsolutePath=" + d.getAbsolutePath());
		System.out.println("d.getParent=" + d.getParent());
		System.out.println("d.length=" + d.length());
		System.out.println("d.exit=" + d.exists());
		
		
		
		
	}

}
