package com.pattern.singleton.eg;

/**
 * 双重校验锁
 * 采用双锁机制，安全且在多线程情况下能保持高性能
 * getInstance() 的性能对应用程序很关键
 */
public class Singleton4 {
    /**
     * volatile在Java并发编程中常用于保持内存可见性和防止指令重排序
     * 声明变量是volatile的，JVM保证了每次读变量都从内存中读，跳过CPU cache这一步.在读取volatile类型的变量时总会返回最新写入的值
     */
    private volatile static Singleton4 instance;

    private Singleton4 (){}

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
