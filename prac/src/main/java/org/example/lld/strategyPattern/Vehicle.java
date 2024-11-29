package org.example.lld.strategyPattern;

import org.example.lld.strategyPattern.service.DriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategyObject;

    Vehicle(DriveStrategy driveStrategyObj){
        this.driveStrategyObject = driveStrategyObj;
    }

    public void drive(){
        driveStrategyObject.drive();
    }
}
