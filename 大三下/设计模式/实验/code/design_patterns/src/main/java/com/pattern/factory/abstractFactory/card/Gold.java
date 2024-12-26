package com.pattern.factory.abstractFactory.card;

/**
 * 接口实现类 金卡
 */
public class Gold implements Type{
    @Override
    public void issue() {
        System.out.println("发行金卡");
    }
}
