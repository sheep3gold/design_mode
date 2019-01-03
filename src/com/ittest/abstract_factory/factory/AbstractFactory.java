package com.ittest.abstract_factory.factory;

public abstract class AbstractFactory {
    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();

    public abstract Food createFood();
}
