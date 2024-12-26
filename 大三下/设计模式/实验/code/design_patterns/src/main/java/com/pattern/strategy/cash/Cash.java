package com.pattern.strategy.cash;

/**
 * 抽象策略类
 */
public interface Cash {
    double acceptCash(double money);    //参数为原价 返回当前价
}
