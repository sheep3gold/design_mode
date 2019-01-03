package com.ittest.factory;

import java.security.PublicKey;

public class PlaneFactory extends VehicleFactory{
    public Plane create() {
        return new Plane();
    }
}
