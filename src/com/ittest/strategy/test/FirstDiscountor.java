package com.ittest.strategy.test;

public class FirstDiscountor implements Discountor {
    private double rate = 0.5;
    @Override
    public double discountRate() {
        return rate;
    }
}
