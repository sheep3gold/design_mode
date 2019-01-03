package com.ittest.strategy.test;

public class Product implements Discountable{
    private int price;
//    private Discountor discountor = new SecondDiscountor();

    public Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                '}';
    }

    @Override
    public double discount(Discountor discountor) {
        return discountor.discountRate()*price;
    }
}
