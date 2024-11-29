package org.example.lld.elevatorSystem;

import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorCar {
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private Queue<Integer> upQueue;
    private Queue<Integer> downQueue;
    private ElevatorDoor door;

    public ElevatorCar() {
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.STOPPED;
        this.upQueue = new PriorityQueue<>();
        this.downQueue = new PriorityQueue<>((a, b) -> b - a); // Max-heap for downQueue
        this.door = new ElevatorDoor();
    }

    public void addExternalRequest(ExternalDispatchRequest request) {

        if (request.getDirection() == Direction.UP) {
            upQueue.add(request.getFloor());
        } else {
            downQueue.add(request.getFloor());
        }
        if (direction == Direction.IDLE) {
            direction = request.getDirection();
            move();
        }
    }

    public void addInternalRequest(InternalDispatchRequest request) {
        door.closeDoor();
        // Update direction based on internal request
        if (request.getFloor() > currentFloor) {
            direction = Direction.UP;
            upQueue.add(request.getFloor());
        } else if (request.getFloor() < currentFloor) {
            direction = Direction.DOWN;
            downQueue.add(request.getFloor());
        }
        move();
    }

    public void move() {
        if (direction == Direction.UP && !upQueue.isEmpty()) {
            currentFloor = upQueue.poll();
        } else if (direction == Direction.DOWN && !downQueue.isEmpty()) {
            currentFloor = downQueue.poll();
        }

        if (upQueue.isEmpty() && downQueue.isEmpty()) {
            direction = Direction.IDLE;
            state = ElevatorState.STOPPED;
        } else {
            state = ElevatorState.MOVING;
        }
        door.openDoor(currentFloor);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getState() {
        return state;
    }
}

