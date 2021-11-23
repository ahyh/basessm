package com.yanhuan.yhssm.dynamo.proxy;

import com.yanhuan.yhssm.dynamo.factory.DatabaseFactory;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class DyMapperProxy<T> implements InvocationHandler, Serializable {

    private Class<T> dyMapperInterface;
    private Map<Method, DyMapperMethod> methodCacheMap;

    public DyMapperProxy(Class<T> dyMapperInterface, Map<Method, DyMapperMethod> methodCacheMap) {
        this.dyMapperInterface = dyMapperInterface;
        this.methodCacheMap = methodCacheMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (Object.class.equals(method.getDeclaringClass())) {
                return method.invoke(this, args);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        DyMapperMethod dyMapperMethod = cachedMapperMethod(method);
        return dyMapperMethod.execute(args);
    }

    private DyMapperMethod cachedMapperMethod(Method method) {
        DyMapperMethod mapperMethod = methodCacheMap.get(method);
        if (mapperMethod == null) {
            DatabaseFactory databaseFactory = new DatabaseFactory();
            mapperMethod = new DyMapperMethod(dyMapperInterface, method, databaseFactory);
            methodCacheMap.put(method, mapperMethod);
        }
        return mapperMethod;
    }
}
