package com.pattern.strategy.cash;

/**
 * 具体策略类 返利收费子类
 */
public class CashReturn implements Cash{
    private double moneyCondition=0.0d; //返利条件
    private double moneyReturn=0.0d;    //返利值

    public CashReturn(String moneyCondition,String moneyReturn) {
        this.moneyCondition = Double.valueOf(moneyCondition);
        this.moneyReturn = Double.valueOf(moneyReturn);
    }

    @Override
    public double acceptCash(double money) {
        double r=money;
        if(money>=moneyCondition) r=money-moneyReturn;
        return r;
    }
}