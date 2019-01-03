package com.ittest.strategy;

import com.ittest.factory.Car;

public class Cat implements java.lang.Comparable<Cat>{
    private int height;
    private int weight;
    private java.util.Comparator<Cat> comparator=new CatHeightComparator();

    public java.util.Comparator getComparator() {
        return comparator;
    }

    public void setComparator(java.util.Comparator comparator) {
        this.comparator = comparator;
    }

    public Cat(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        return comparator.compare(this, o);
    }
}
