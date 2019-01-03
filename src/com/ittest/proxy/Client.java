package com.ittest.proxy;

public class Client {
    public static void main(String[] args) throws Exception{
        Tank tank = new Tank();
        InvocationHandler h = new TimeHandler(tank);

        Movable m = (Movable) Proxy.newProxyInstance(Movable.class, h);

        m.move();
    }
}
