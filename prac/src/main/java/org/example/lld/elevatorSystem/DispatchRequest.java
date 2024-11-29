package org.example.lld.elevatorSystem;

public abstract class DispatchRequest {

    private int floor;

    public DispatchRequest(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }
}
