package com.ittest.strategy;

public class Dog implements Comparable{
    private int food;

    public int getFood() {
        return food;
    }


    public Dog(int food) {
        this.food = food;
    }

    public void setFood(int food) {
        this.food = food;
    }



    @Override
    public int compareTo(Object o) {
        if (o instanceof Dog) {
            Dog c = (Dog) o;
            if (this.food > c.food) {
                return 1;
            } else if (this.food < c.food) {
                return -1;
            } else return 0;
        }
        throw new IllegalStateException();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
