package com.company;

abstract public class TransportationVehicle
        implements MovableMachine {
    int horsepower;
    protected TransportationVehicle(){}
    public void move(){}
    public String toString() {
        return "A Transportation Vehicle";
    }
}

class NewEnergyVehicle extends TransportationVehicle
        implements BatteryMachine {
    protected NewEnergyVehicle(){}
    public void charge(){}
    public String toString() {
        return "A Transportation Vehicle with Battery";
    }
}

class TraditionalVehicle extends TransportationVehicle
        implements PetrolMachine {
    protected TraditionalVehicle(){}
    public void addPetrol(){}
    public String toString() {
        return "A Transportation Vehicle with Petrol";
    }
}

class HybirdVehicle extends TransportationVehicle
        implements PetrolMachine, BatteryMachine {
    protected HybirdVehicle(){}
    public void charge(){}
    public void addPetrol(){}
    public String toString() {
        return "A Transportation Vehicle with Battery and Petrol";
    }
}

class VehicleFactory{
    static MovableMachine getVehicle(String s){
        if(s.equals("NewEnergyVehicle")) return new NewEnergyVehicle();//还没对
        else if(s.equals("TraditionalVehicle")) return new TraditionalVehicle();
        else if(s.equals("HybirdVehicle")) return new HybirdVehicle();
        else return null;
    }
}
//        2.构造一个抽象类TransportationVehicle，该类中有个变量为horsepower（整形），其实现了一个接口MovableMachine，该接口中有个方法move()
//        3.创建NewEnergyVehicle类，其继承了TransportationVehicle，并实现了个接口，BatteryMachine，该接口中有个方法charge()
//        4.创建TraditionalVehicle类，其继承了TransportationVehicle，并实现了个接口，PetrolMachine，该接口中有个方法addPetrol ()
//        5.创建HybirdVehicle类，其继承了TransportationVehicle，并实现了个接口，PetrolMachine，BatteryMachine接口
//        6.每个类都必须有toString方法，TransportationVehicle调用toString输出"A Transportation Vehicle"，
//          其他的比如NewEnergyVehicle调用toString输出"A Transportation Vehicle with Battery"，其他的类类似。
//        7.创建VehicleFactory类，在该该类中有个静态方法getVehicle(String s)，返回类型为MovableMachine。
//          当传递给字符串"NewEnergyVehicle"，则返回NewEnergyVehicle对象。其他类似。
//        8.编写一个测试类TestTransportationVehicle，在main方法中测试和输出如下，注意引用类型为MovableMachine：

