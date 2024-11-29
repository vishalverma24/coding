package org.example.lld.elevatorSystem;

public class Main {
    public static void main(String[] args){
        int size = 1;
        ElevatorSystem system = new ElevatorSystem(size);
        system.requestExternalElevator(5, Direction.DOWN);
        system.requestInternalElevator(0);
        system.requestExternalElevator(3,Direction.DOWN);
        system.requestInternalElevator(1);
    }
}
