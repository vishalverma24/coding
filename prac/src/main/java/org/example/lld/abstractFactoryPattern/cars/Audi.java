package org.example.lld.abstractFactoryPattern.cars;

public class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("driving audi, luxury car");
    }
}
