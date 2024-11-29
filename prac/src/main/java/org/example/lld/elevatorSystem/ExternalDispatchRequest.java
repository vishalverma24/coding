package org.example.lld.elevatorSystem;

public class ExternalDispatchRequest extends DispatchRequest{
    private Direction direction;

    public ExternalDispatchRequest(int floor, Direction direction) {
        super(floor);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
