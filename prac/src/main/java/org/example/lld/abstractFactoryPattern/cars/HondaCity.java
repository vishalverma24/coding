package org.example.lld.abstractFactoryPattern.cars;

public class HondaCity implements Car {
    @Override
    public void drive() {
        System.out.println("driving Honda City, normal car");
    }
}
