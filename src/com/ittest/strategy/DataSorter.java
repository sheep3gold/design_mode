package com.ittest.strategy;

public class DataSorter {
    public static void sort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    public static void sort(Object[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                java.lang.Comparable o1 = (java.lang.Comparable) a[j];
                java.lang.Comparable o2 = (java.lang.Comparable) a[j + 1];
                if (o1.compareTo(o2) > 0) {
                    Object temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

}
