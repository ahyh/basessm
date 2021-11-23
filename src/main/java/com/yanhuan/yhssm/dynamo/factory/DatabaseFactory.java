package com.yanhuan.yhssm.dynamo.factory;

import com.google.common.collect.Lists;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseFactory {

    public T get(String table, Class<T> clazz, Object id) {
        try {
            T t = clazz.newInstance();
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<T> batchGet(String table, Class<T> clazz){
        return Lists.newArrayList();
    }
}
