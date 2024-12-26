package com.pattern.template.eg;

//客户类
public class Client {
    public static void main(String[] args) {
        AbstractClass t=new ConcreteClass();
        t.templateMethod();
    }
}
