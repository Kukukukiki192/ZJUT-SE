package com.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {
	//方法1
//	public static String getSHA256(String str) {
//		MessageDigest messageDigest;
//		String encodestr = "";
//		try {
//			messageDigest = MessageDigest.getInstance("SHA-256");
//			messageDigest.update(str.getBytes("UTF-8"));
//			encodestr = byte2Hex(messageDigest.digest());
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return encodestr;
//	}
//
//	private static String byte2Hex(byte[] bytes) {//将byte转为16进制
//		StringBuffer sb= new StringBuffer();
//		String t= null;
//		for (int i = 0; i < bytes.length; i++) {
//			t= Integer.toHexString(bytes[i] & 0xFF);
//			if (t.length() == 1)  sb.append("0");//得到一位的进行补0操作
//			sb.append(t);
//		}
//		return sb.toString();
//	}//16进制字符串两位占一个字节
	//方法2
	public static String getSHA256(String str) {
		return encrypt("SHA-256",str);
	}
	public static String encrypt(String algorithm,String str) {
		try {
			StringBuilder sb=new StringBuilder();
			MessageDigest md=MessageDigest.getInstance(algorithm);
			byte[] bytes=md.digest(str.getBytes("UTF-8"));
			for(byte b:bytes) {
				String hex=Integer.toHexString(b&0xFF);
				if(hex.length()==1) sb.append("0");
				sb.append(hex);
			}
			return sb.toString();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String args[]) {
		System.out.println(getSHA256("123456"));
		System.out.println(getSHA256("12345"));
	}
}