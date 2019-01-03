package com.ittest.proxy.compile.test;

import com.ittest.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler {
    private Object target;

    public TransactionHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {
        System.out.println("Tansaction Start");
        try {
            m.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Transaction Commit");
    }
}
