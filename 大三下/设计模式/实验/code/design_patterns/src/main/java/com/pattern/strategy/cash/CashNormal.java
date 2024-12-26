package com.pattern.strategy.cash;

/**
 * 具体策略类 正常收费子类
 */
public class CashNormal implements Cash{
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
