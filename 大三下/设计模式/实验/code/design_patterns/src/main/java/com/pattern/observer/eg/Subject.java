package com.pattern.observer.eg;

import com.pattern.observer.eg.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知者/主题(可写一个抽象主题,多个具体主题)
 * 可以有多个观察者接收它发出的通知
 */
public class Subject {

    //ArrayList 存放观察者们
    private List<Observer> observers = new ArrayList<Observer>();
    //被观察者状态
    private int state;

    public int getState() {
        return state;
    }

    //更新被观察者状态
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    //增加观察者
    public void add(Observer observer) {
        observers.add(observer);
    }

    //删除观察者
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
