package com.company;

public class TestTransportationVehicle {
    public static void main(String[] args) {
        MovableMachine v1=VehicleFactory. getVehicle("NewEnergyVehicle");
        MovableMachine v2=VehicleFactory. getVehicle("TraditionalVehicle");
        MovableMachine v3=VehicleFactory. getVehicle("HybirdVehicle");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        //Java中直接输出一个类的对象的时候，会调用这个类的toString()方法
    }
}
