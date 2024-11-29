package org.example.lld.elevatorSystem;

import com.sun.net.httpserver.Request;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {

    ElevatorController elevatorController;

    public ElevatorSystem(int size) {
        List<ElevatorCar> elevatorCarList = new ArrayList<>();
        for(int i=0;i<size;i++){
            elevatorCarList.add(new ElevatorCar());
        }

        this.elevatorController = new ElevatorController(elevatorCarList);
    }

    public void requestExternalElevator(int floor, Direction direction) {
        ExternalDispatchRequest request = new ExternalDispatchRequest(floor, direction);
        elevatorController.handleExternalRequest(request);
    }

    public void requestInternalElevator(int floor) {
        InternalDispatchRequest request = new InternalDispatchRequest(floor);
        elevatorController.handleInternalRequest(request);
    }

}
