package com.bjpowernode.util;

public class ServiceFactory {
    public static Object getService(Object service){

        return new TransactionInvocationHandler(service).getProxy();
    }
}
