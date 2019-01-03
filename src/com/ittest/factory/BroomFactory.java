package com.ittest.factory;

public class BroomFactory extends VehicleFactory {
    @Override
    Moveable create() {
        return new Broom();
    }
}
