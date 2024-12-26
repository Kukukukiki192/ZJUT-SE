package com.pattern.strategy.cash;

/**
 * 具体策略类 打折收费子类
 */
public class CashRebate implements Cash{
    private double moneyRebate=1d;

    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.valueOf(moneyRebate);
    }

    @Override
    public double acceptCash(double money) {
        return money*moneyRebate;
    }
}