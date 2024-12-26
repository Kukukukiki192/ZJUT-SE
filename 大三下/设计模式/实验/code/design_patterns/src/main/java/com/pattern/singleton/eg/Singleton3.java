package com.pattern.singleton.eg;

/**
 * 饿汉式
 * 常用，但容易产生垃圾对象
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 */
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();
    private Singleton3 (){}

    public static Singleton3 getInstance() {
        return instance;
    }
}
