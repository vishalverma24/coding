package org.example.lld.strategyPattern;

public class Main {
    public static void main(String[] args){
        Vehicle v1 = new GoodsVehicle();
        Vehicle v2 = new OffRoadVehicle();

        v1.drive();
        v2.drive();
    }
}
