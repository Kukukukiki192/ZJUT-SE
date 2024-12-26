package com.company;

public interface MovableMachine {
    public void move();
}

interface BatteryMachine extends MovableMachine {
    public void charge();
}

interface PetrolMachine extends MovableMachine {
    public void addPetrol();
}
