package org.example.lld.strategyPattern;

import org.example.lld.strategyPattern.serviceImpl.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
