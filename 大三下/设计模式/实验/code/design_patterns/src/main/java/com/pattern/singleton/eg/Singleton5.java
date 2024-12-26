package com.pattern.singleton.eg;

/**
 * 登记式/静态内部类
 *  Singleton 类被装载了，instance 不一定被初始化
 *  SingletonHolder类没有被主动使用，只有通过显式调用getInstance方法时，才会显式装载SingletonHolder类，从而实例化instance
 */
public class Singleton5 {

    private static class Singleton5Holder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5 (){}

    public static Singleton5 getInstance() {
        return Singleton5Holder.INSTANCE;
    }
}
