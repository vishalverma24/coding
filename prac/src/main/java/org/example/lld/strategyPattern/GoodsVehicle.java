package org.example.lld.strategyPattern;

import org.example.lld.strategyPattern.serviceImpl.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
