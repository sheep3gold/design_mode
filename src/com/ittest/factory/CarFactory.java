package com.ittest.factory;

public class CarFactory extends VehicleFactory{
    public Car create() {
        return new Car();
    }
}
