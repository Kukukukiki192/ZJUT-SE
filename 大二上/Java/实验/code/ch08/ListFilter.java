package cn.edu.zjut.java.ch08;

import java.io.*;

//第①步：声明过滤类ListFilter并实现FilenameFilter接口中的accept方法
class ListFilter implements FilenameFilter {
	private String pre = "", ext = "";// pre表示文件前缀，ext表示文件后缀

	public ListFilter(String filterstr) {
		int i, j;
		filterstr = filterstr.toLowerCase();
		i = filterstr.indexOf("*");
		j = filterstr.indexOf(".");
		if (i > 0)
			pre = filterstr.substring(0, i);
		if (i == -1 & j > 0)
			pre = filterstr.substring(0, j);
		if (j >= 0)
			ext = filterstr.substring(j + 1);
		
		System.out.println(pre + "  " + ext);
	}

	// 实现accept方法
	public boolean accept(File dir, String filename) {
		//System.out.println(dir);
		boolean y = true;
		try {
			filename = filename.toLowerCase();
			y = filename.startsWith(pre) & filename.endsWith(ext);
		} catch (NullPointerException e) {
		}
		return y;
	}
}
