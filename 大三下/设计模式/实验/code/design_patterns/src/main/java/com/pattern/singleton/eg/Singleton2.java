package com.pattern.singleton.eg;

/**
 * 懒汉式，线程安全
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率
 * 初始化instance时才会出现线程安全问题，一旦初始化完成就不存在了。
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2 (){}

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}