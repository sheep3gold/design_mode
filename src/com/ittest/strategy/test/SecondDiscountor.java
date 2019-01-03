package com.ittest.strategy.test;

public class SecondDiscountor implements Discountor {
    @Override
    public double discountRate() {
        return 0.7;
    }
}
