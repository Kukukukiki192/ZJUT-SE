package com.pattern.adapter;

//客户端
public class Client {
    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        Target target1 = new ClassAdapter();
        target1.request();

        System.out.println("对象适配器模式测试：");
        Adaptee adaptee = new Adaptee();
        Target target2 = new ObjectAdapter(adaptee);
        target2.request();
    }
}