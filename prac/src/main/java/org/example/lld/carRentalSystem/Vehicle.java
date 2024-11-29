package org.example.lld.carRentalSystem;

import org.example.lld.parkingLot.VehicleType;

public class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;
    int costPerMonth;
    Store store;
    Boolean isAvailableToRent;

    public Vehicle(String  vehicleNumber, VehicleType vehicleType, int costPerMonth, Store store) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.costPerMonth = costPerMonth;
        this.isAvailableToRent = true;
        this.store = store;
    }
}
