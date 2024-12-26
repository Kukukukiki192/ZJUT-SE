package com.pattern.observer.eg;

/**
 * 抽象观察者
 */
public abstract class Observer {
    //在抽象类里有一个 ArrayList 存放观察者们
    protected Subject subject;  //接口只可以定义static final成员变量：Subject subject=new Subject();

    public abstract void update();
}
