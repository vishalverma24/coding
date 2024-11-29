package org.example.lld.abstractFactoryPattern;

import org.example.lld.abstractFactoryPattern.factories.CarFactory;
import org.example.lld.abstractFactoryPattern.cars.Car;

public class Main {
    public static void main(String[] args){

        CarFactory factory = FactoryProducer.getFactory("Luxury");
        Car car = factory.createVehicle("Audi");
        CarFactory factory2 = FactoryProducer.getFactory("Normal");
        Car car2 = factory2.createVehicle("Swift");
        car.drive();
        car2.drive();
    }
}
