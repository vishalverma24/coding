package org.example.lld.strategyPattern.serviceImpl;

import org.example.lld.strategyPattern.service.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("normal drive");
    }
}
