package org.example.lld.nullObject;

public class Main {

    public static void main(String[] args){

        Vehicle v1 = VehicleFactory.getVehicleObject("Car");
        Vehicle v2 = VehicleFactory.getVehicleObject("Bike");
        printVehicleDetails(v1);
        printVehicleDetails(v2);
    }

    private static void printVehicleDetails(Vehicle vehicle) {


        System.out.println("Seats : " + vehicle.getSeats());
        System.out.println("Fuel Capacity : " + vehicle.getFuelCapacity());

    }
}
