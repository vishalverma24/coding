package org.example.lld.abstractFactoryPattern.factories;

import org.example.lld.abstractFactoryPattern.cars.Car;

public interface CarFactory {

    Car createVehicle(String vehicleType);
}
