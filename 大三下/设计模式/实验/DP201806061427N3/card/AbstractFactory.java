package com.pattern.factory.abstractFactory.card;

/**
 * 抽象工厂类
 */
public abstract class AbstractFactory {

    public abstract Type getType(String type) ;
    public abstract Style getStyle(String style);
}