package com.pattern.strategy.cash;

/**
 * 环境类
 */
public class CashContext {
    private Cash cash;

    public CashContext(String type){
        switch(type){
            case "正常收费":
                CashNormal c1=new CashNormal();
                cash=c1;
                break;
            case "打8折":
                CashRebate c2=new CashRebate("0.8");
                cash=c2;
                break;
            case "满300返100":
                CashReturn c3=new CashReturn("300","100");
                cash=c3;
                break;
        }
    }

    public double getResult(double money){
        return cash.acceptCash(money);
    }
}
