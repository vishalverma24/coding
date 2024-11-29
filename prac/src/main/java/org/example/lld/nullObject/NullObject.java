package org.example.lld.nullObject;

public class NullObject implements Vehicle{

    @Override
    public Integer getSeats() {
        return 0;
    }

    @Override
    public Integer getFuelCapacity() {
        return 0;
    }
}
