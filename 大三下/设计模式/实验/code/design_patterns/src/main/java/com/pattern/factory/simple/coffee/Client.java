package com.pattern.factory.simple.coffee;

public class Client {
    public static void main(String[] args) {
        //创建咖啡店对象
        CoffeeStore coffeeStore=new CoffeeStore();
        //点咖啡
        Coffee coffee = coffeeStore.oderCoffee("Latte");
        System.out.println(coffee.getType());

        coffee = coffeeStore.oderCoffee("American");
        System.out.println(coffee.getType());

    }
}
