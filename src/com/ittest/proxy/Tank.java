package com.ittest.proxy;

import java.util.Random;

public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("Tank Moving...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
