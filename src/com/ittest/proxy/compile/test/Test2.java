package com.ittest.proxy.compile.test;

import com.ittest.proxy.Movable;

import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) {
        Method[] methods = Movable.class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
