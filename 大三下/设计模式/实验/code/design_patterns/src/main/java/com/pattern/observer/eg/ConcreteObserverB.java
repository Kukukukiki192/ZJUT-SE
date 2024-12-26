package com.pattern.observer.eg;

/**
 * 具体观察者
 */
public class ConcreteObserverB extends Observer {

    public ConcreteObserverB(Subject subject){
        this.subject=subject;   //维持一个指向通知者的引用
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("具体观察者B发生改变");
    }
}
