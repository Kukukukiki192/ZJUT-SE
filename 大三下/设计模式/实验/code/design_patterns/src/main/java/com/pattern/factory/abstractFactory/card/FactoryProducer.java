package com.pattern.factory.abstractFactory.card;

/**
 * 工厂生成器类
 */
public class    FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("type")){
            return new TypeFactory();
        } else if(choice.equalsIgnoreCase("style")){
            return new StyleFactory();
        }
        return null;
    }
}
