package com.yanhuan.yhssm.dynamo.proxy;

import com.yanhuan.yhssm.dynamo.dao.PlaylistDao;
import org.apache.ibatis.binding.BindingException;

import java.util.HashMap;
import java.util.Map;

public class MapperProxyFactoryHolder {

    private final static Map<Class<?>, DyMapperProxyFactory<?>> knownMappers = new HashMap();

    static {
        addMapper(PlaylistDao.class);
    }

    public static <T> void addMapper(Class type) {
        if (type.isInterface()) {
            if (hasMapper(type)) {
                throw new BindingException("Type " + type + " is already known to the MapperRegistry.");
            }
            knownMappers.put(type, new DyMapperProxyFactory<T>(type));
        }
    }

    public static  <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }

    public static <T> T getMapper(Class<T> type) {
        final DyMapperProxyFactory<T> mapperProxyFactory = (DyMapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new BindingException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance();
        } catch (Exception e) {
            throw new BindingException("Error getting mapper instance. Cause: " + e, e);
        }
    }
}
