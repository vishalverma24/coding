package org.example.lld.elevatorSystem;

import java.util.List;

public class ElevatorController {
    private List<ElevatorCar> elevators;

    public ElevatorController(List<ElevatorCar> elevators) {
        this.elevators = elevators;
    }

    public void handleExternalRequest(ExternalDispatchRequest request) {
        ElevatorCar bestElevator = findBestElevator(request);
        bestElevator.addExternalRequest(request);
    }

    public void handleInternalRequest(InternalDispatchRequest request) {
        ElevatorCar bestElevator = findBestElevatorForInternal(request);
        bestElevator.addInternalRequest(request);
    }

    private ElevatorCar findBestElevator(ExternalDispatchRequest request) {
        for (ElevatorCar elevator : elevators) {
            if (elevator.getState() == ElevatorState.IDLE) {
                return elevator;
            }
        }
        return elevators.get(0); // Default to the first elevator if no idle elevator is found
    }

    private ElevatorCar findBestElevatorForInternal(InternalDispatchRequest request) {
        return elevators.get(0); // Simplified: return the first elevator
    }

    public List<ElevatorCar> getElevators() {
        return elevators;
    }
}

