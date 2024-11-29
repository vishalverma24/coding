package org.example.lld.carRentalSystem;

import org.example.lld.parkingLot.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        VehicleRentalSystem system = new VehicleRentalSystem();

        List<Store> stores = new ArrayList<>();

        Store store = new Store(1,new Location(147001));
        stores.add(store);
        stores.add(new Store(2,new Location(147002)));
        system.addStore(stores);


        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("BH123", VehicleType.HB,8000,store));
        vehicles.add(new Vehicle("BH444", VehicleType.SUV,12000,store));
        system.addVehicles(vehicles);
        User user = new User(123,"jokic",111222);
        system.registerOrLogin(user);

        List<Vehicle> availableToRent = system.getAvailableVehicles(store);

        Vehicle toRent = availableToRent.get(0);

        int renTimelineMonths = 2;
        system.bookVehicle(user,toRent,renTimelineMonths);

    }
}
