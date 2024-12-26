package com.filter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class TextResponseWrapper extends HttpServletResponseWrapper {
    //内部类扩展ServletOutputStream，把写给它的数据写到字节数组中而不发给客户
    private static class ByteArrayServletOutputStream 
          extends ServletOutputStream{
       ByteArrayOutputStream baos;
       ByteArrayServletOutputStream(ByteArrayOutputStream baos){
         this.baos = baos;
       }
       public void write(int param) throws java.io.IOException{
         baos.write(param);
       }
       public boolean isReady(){
    	      return true; 
       }
       public void setWriteListener(WriteListener listener){
       }
    }
    //PrintWriter和ServletOutputStream使用的字节数组输出流
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    //由ByteArrayOutputStream创建PrintWriter
    private PrintWriter pw = new PrintWriter(baos);
   //由ByteArrayOutputStream创建ServletOutputStream
    private ByteArrayServletOutputStream basos 
                = new ByteArrayServletOutputStream(baos);
    // 构造方法，包装了响应对象 
    public TextResponseWrapper(HttpServletResponse response){
       super(response);
    }
    @Override
    public PrintWriter getWriter(){
         return pw;         //返回定制的PrintWriter
    }
    @Override 
    public ServletOutputStream getOutputStream(){
         return basos;      //返回定制的ServletOutputStream对象
    }
    //将字节输出流转换成字节数组 
    byte[] toByteArray(){
       return baos.toByteArray();
    }
}

