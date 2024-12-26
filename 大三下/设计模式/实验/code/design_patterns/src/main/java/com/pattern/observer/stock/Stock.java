package com.pattern.observer.stock;

/**
 * 抽象观察者 股票
 */
public abstract class Stock {
    protected Notifier notifier;
    public abstract void update(float price);
}
