package com.pattern.singleton.eg;

/**
 * eg (饿汉式 常用)
 * 通常，普通类的构造函数是公有的，外部类可以通过“new 构造函数()”来生成多个实例。
 * 但是，如果将类的构造函数设为私有的，外部类就无法调用该构造函数，也就无法生成多个实例。
 * 这时该类自身必须定义一个静态私有实例，并向外提供一个静态的公有函数用于创建或获取该静态私有实例。
 */
public class SingleObject {

    //创建 SingleObject 的一个对象
    private static SingleObject instance = new SingleObject();

    //让构造函数为 private，这样该类就不会被实例化多个对象
    private SingleObject(){}

    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
//经验之谈：
// 一般情况下，不建议使用第 1 种和第 2 种懒汉方式，建议使用第 3 种饿汉方式。
// 只有在要明确实现 lazy loading 效果时，才会使用第 5 种登记方式。
// 如果涉及到反序列化创建对象时，可以尝试使用第 6 种枚举方式。
// 如果有其他特殊的需求，可以考虑使用第 4 种双检锁方式