package com.ittest.strategy;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {9, 5, 3, 7, 1};
        Cat[] cats = {new Cat(5, 5), new Cat(1, 1),
                new Cat(3, 3)};
        Dog[] dogs = {new Dog(5), new Dog(1), new Dog(3)};
//        DataSorter.sort(cats);
        Arrays.sort(cats);
        System.out.println(Arrays.toString(cats));
    }
}
