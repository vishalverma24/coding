package org.example.lld.carRentalSystem;

import org.example.lld.parkingLot.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {

    int storeId;
    Location storeLocation;

    List<Vehicle> rented = new ArrayList<>();

    List<Vehicle> available = new ArrayList<>();

    public Store(int storeId, Location storeLocation) {
        this.storeId = storeId;
        this.storeLocation = storeLocation;
    }

}
