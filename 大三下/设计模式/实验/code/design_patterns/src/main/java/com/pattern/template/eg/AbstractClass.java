package com.pattern.template.eg;

//抽象类
public abstract class AbstractClass {
    //模板方法
    final void templateMethod() {
        abstractMethod1();
        abstractMethod2();
        ConcreteMethod();
    }
    //抽象方法1
    abstract void abstractMethod1();
    //抽象方法2
    abstract void abstractMethod2();
    //具体方法
    void ConcreteMethod() {
        //Implementation
    }
}

//System.out.println("抽象类中的具体方法被调用...");