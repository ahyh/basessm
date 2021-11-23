package com.yanhuan.yhssm.dynamo.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DyMapperProxyFactory<T> {

    private final Class<T> mapperInterface;
    private final Map<Method, DyMapperMethod> methodCache = new ConcurrentHashMap<Method, DyMapperMethod>();

    public DyMapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Class<T> getMapperInterface() {
        return mapperInterface;
    }

    public Map<Method, DyMapperMethod> getMethodCache() {
        return methodCache;
    }

    public T newInstance(){
        final DyMapperProxy<T> mapperProxy = new DyMapperProxy<T>(mapperInterface, methodCache);
        return newInstance(mapperProxy);
    }

    public T newInstance(DyMapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy);
    }

}
