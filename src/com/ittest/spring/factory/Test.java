package com.ittest.spring.factory;

import java.io.IOException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
        BeanFactory f = new ClassPathApplicationContext("src/com/ittest/spring/factory/applicationContext.xml");
        Object v = f.getBean("v");
        Moveable m = (Moveable) v;
        m.run();
    }
}
