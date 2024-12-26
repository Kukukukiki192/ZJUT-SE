package com.pattern.observer.eg;

/**
 * 具体观察者
 */
public class ConcreteObserverA extends Observer {

    public ConcreteObserverA(Subject subject){
        this.subject=subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("具体观察者A发生改变");
    }
}
