package org.example.lld.carRentalSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VehicleRentalSystem {

    List<Store> storeList = new ArrayList<>();
    List<User> userList = new ArrayList<>();

    List<Reservation> reservations = new ArrayList<>();

    public void registerOrLogin(User user) {
        if(!userList.contains(user)) userList.add(user);
    }

    public void addStore(List<Store> stores) {
        storeList.addAll(stores);
    }

    public List<Vehicle> getAvailableVehicles(Store store) {
        return store.available;
    }

    public void bookVehicle(User user, Vehicle vehicle, int months){
        Reservation reservation = createReservation(user,vehicle,months);
        if(pay(user, vehicle, months, reservation)){
            vehicle.store.available.remove(vehicle);
            vehicle.store.rented.add(vehicle);
            if(reservation.paid) System.out.println("Vehicle reserved");
            reservations.add(reservation);
        }
        System.out.println("vehicle: " + vehicle.vehicleNumber + " booked by: " + user.userName );
        System.out.println("Do pick up your vehicle from store number: " + vehicle.store.storeId + " on: " + reservation.pickUpDate);
        System.out.println("Return on: " + reservation.returnDate);
    }

    private Reservation createReservation(User user, Vehicle vehicle, int months) {

        return new Reservation(UUID.randomUUID().toString(),user,vehicle, LocalDateTime.now(),months,vehicle.store,false);
    }

    private Boolean pay(User user, Vehicle vehicle, int months, Reservation reservation) {
        reservation.setPaid(true);
        System.out.println(user.userName + " paid " + vehicle.costPerMonth*months);
        return true;
    }

    public void addVehicles(List<Vehicle> vehicles) {
        vehicles.forEach(vehicle -> vehicle.store.available.add(vehicle));
    }
}
