package org.example.lld.nullObject;

public class VehicleFactory {

    static Vehicle getVehicleObject(String typeOfVehicle){

        if("Car".equals(typeOfVehicle)) {

            return new Car();
        }

        return new NullObject();
    }
}
