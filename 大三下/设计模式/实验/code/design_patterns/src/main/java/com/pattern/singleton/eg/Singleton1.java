package com.pattern.singleton.eg;

/**
 * 懒汉式，线程不安全
 * 没有加锁synchronized 不支持多线程
 */
public class Singleton1 {
    private static Singleton1 instance;
    private Singleton1 (){}

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
