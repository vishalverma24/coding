package org.example.lld.nullObject;

public class Car implements Vehicle{

    Integer seats;
    Integer fuelCapacity;

    public Car(){
        this.seats=4;
        this.fuelCapacity=35;
    }
    private Car(Integer seat,Integer fuel){
        this.seats=seat;
        this.fuelCapacity=fuel;
    }

    @Override
    public Integer getSeats() {
        return null;
    }

    @Override
    public Integer getFuelCapacity() {
        return null;
    }
}
