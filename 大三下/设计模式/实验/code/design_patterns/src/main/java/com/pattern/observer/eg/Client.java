package com.pattern.observer.eg;

public class Client {
    public static void main(String[] args) {
        //通知者 包含增删观察者方法、更新被观察者状态并通知所有观察者状态改变的方法
        Subject subject = new Subject();
        Observer A = new ConcreteObserverA(subject);//加入通知者 包含update方法,接收被观察者发出的通知
        Observer B = new ConcreteObserverB(subject);

        //更新被观察者状态 通知所有观察者
        System.out.println("First state change: 1");
        subject.setState(1);
        System.out.println("Second state change: 2");
        subject.setState(2);
        System.out.println("Third state change: 3");
        subject.setState(3);
    }
}
