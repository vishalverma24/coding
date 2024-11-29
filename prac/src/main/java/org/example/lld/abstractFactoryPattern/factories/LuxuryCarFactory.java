package org.example.lld.abstractFactoryPattern.factories;

import org.example.lld.abstractFactoryPattern.cars.Audi;
import org.example.lld.abstractFactoryPattern.cars.Car;

public class LuxuryCarFactory implements CarFactory {
    @Override
    public Car createVehicle(String vehicleType) {
        switch (vehicleType){
            case "Audi":
                return new Audi();
            default:
                return null;
        }
    }
}
