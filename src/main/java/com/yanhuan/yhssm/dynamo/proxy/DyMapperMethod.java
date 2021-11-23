package com.yanhuan.yhssm.dynamo.proxy;

import com.yanhuan.yhssm.dynamo.factory.DatabaseFactory;
import com.yanhuan.yhssm.dynamo.factory.DyConfig;

import java.lang.reflect.Method;

public class DyMapperMethod {

    private Class<?> mapperInterface;
    private MethodDesc methodDesc;
    private DatabaseFactory databaseFactory;

    public DyMapperMethod(Class<?> mapperInterface, Method method, DatabaseFactory databaseFactory) {
        this.mapperInterface = mapperInterface;
        this.methodDesc = DyConfig.get(method);
        this.databaseFactory = databaseFactory;
    }

    public Object execute(Object[] args) {
        System.out.println(args);
        if (args == null || args.length == 0) {
            return null;
        }
        if (methodDesc.isPrimary()) {

            return databaseFactory.get(methodDesc.getTable(), methodDesc.getClazz(), args[0]);

        } else {
            String indexName = methodDesc.getIndexName();
            String indexHashKey = methodDesc.getHashKey();
            String indexSortKey = methodDesc.getSortKey();
            String op = methodDesc.getOp();
        }
        return "success";
    }

    public MethodDesc getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(MethodDesc methodDesc) {
        this.methodDesc = methodDesc;
    }
}
