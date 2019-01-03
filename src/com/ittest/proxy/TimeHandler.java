package com.ittest.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    public Object getO() {
        return target;
    }

    public void setO(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {
        long start = System.currentTimeMillis();
        System.out.println("starttime:" + start);
        try {
            m.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }
}
