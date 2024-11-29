package org.example.lld.carRentalSystem;

import java.time.LocalDateTime;
public class Reservation {

    String reservationId;
    User user;
    Vehicle vehicle;
    LocalDateTime bookingDate;

    int timelineMonths;
    LocalDateTime pickUpDate;
    LocalDateTime returnDate;
    Store store;
    Boolean paid;
    Boolean completed;

    public Reservation(String reservationId, User user, Vehicle vehicle, LocalDateTime bookingDate, int months, Store store,Boolean paid) {
        this.reservationId = reservationId;
        this.user = user;
        this.vehicle = vehicle;
        this.timelineMonths=months;
        this.bookingDate = bookingDate;
        this.pickUpDate = bookingDate.plusDays(3);
        this.returnDate = bookingDate.plusDays(33);
        this.store = store;
        this.paid = paid;
    }

    public Boolean setPaid(Boolean value){
        this.paid = value;
        return value;
    }
}
