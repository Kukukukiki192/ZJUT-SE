package com.pattern.factory.abstractFactory.card;

/**
 * 接口实现类 银卡
 */
public class Silver implements Type{
    @Override
    public void issue() {
        System.out.println("发行银卡");
    }
}
