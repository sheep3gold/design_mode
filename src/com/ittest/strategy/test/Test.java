package com.ittest.strategy.test;

public class Test {
    public static void main(String[] args) {
        Product product = new Product(100);
        double discount = product.discount(new FirstDiscountor());
        System.out.println(discount);
    }
}
