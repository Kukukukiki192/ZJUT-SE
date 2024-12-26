package com.demo;
import javax.servlet.*;
import java.io.*;
import java.time.LocalTime;

public class Executor implements Runnable{  
  private AsyncContext actx=null;  
  public Executor(AsyncContext actx){  
       this.actx=actx;  
   }  
  // 实现线程体的run()
  public void run(){  
    try{  
       // 等待10秒钟，以模拟业务方法的执行  
       Thread.sleep(10000);  
       PrintWriter out=actx.getResponse().getWriter();  
       out.println("业务处理完毕的时间："+ LocalTime.now()+".");  
       out.flush();  
       actx.complete();  // 结束异步线程
     }catch(Exception e){  
        e.printStackTrace();  
     }  
  }  
}

