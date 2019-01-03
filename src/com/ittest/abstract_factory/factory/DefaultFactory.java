package com.ittest.abstract_factory.factory;

public class DefaultFactory extends AbstractFactory{

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new Ak47();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }
}
