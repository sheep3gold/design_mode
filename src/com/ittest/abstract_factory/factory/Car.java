package com.ittest.abstract_factory.factory;

public class Car extends Vehicle{
    private static Car car = new Car();
//    private static List<Car> cars = new ArrayList<>();
    public Car(){}

    public static Car getInstance() {
        return car;
    }

    public void run() {
        System.out.println("冒着烟，奔跑中car...");
    }
}
