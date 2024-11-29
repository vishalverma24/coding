package org.example.lld.abstractFactoryPattern.factories;

import org.example.lld.abstractFactoryPattern.cars.Car;
import org.example.lld.abstractFactoryPattern.cars.HondaCity;
import org.example.lld.abstractFactoryPattern.cars.Swift;

public class NormalCarFactory implements CarFactory {
    @Override
    public Car createVehicle(String vehicleType) {
        switch (vehicleType){
            case "Honda City":
                return new HondaCity();
            case "Swift":
                return new Swift();
            default:
                return null;
        }
    }
}
