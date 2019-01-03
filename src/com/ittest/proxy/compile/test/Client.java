package com.ittest.proxy.compile.test;

import com.ittest.proxy.InvocationHandler;
import com.ittest.proxy.Proxy;
import com.ittest.proxy.TimeHandler;

public class Client {
    public static void main(String[] args) throws Exception {
        UserMgrImpl userMgr = new UserMgrImpl();
        InvocationHandler h = new TransactionHandler(userMgr);
//        InvocationHandler h2 = new TimeHandler(h);
        UserMgr u = (UserMgr) Proxy.newProxyInstance(UserMgr.class, h);
        u.addUser();
    }
}
