package org.example.lld.parkingLot.dto;

import org.example.lld.parkingLot.dto.ParkingSpot;
import org.example.lld.parkingLot.dto.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
}
