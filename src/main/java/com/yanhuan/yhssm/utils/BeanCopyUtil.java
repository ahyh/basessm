package com.yanhuan.yhssm.utils;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.google.common.collect.Maps;
import net.sf.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeanCopyUtil {

    private static final String CacheKeySplitter = "@";
    private static final Map<String, BeanCopier> BeanCopierCache = Maps.newConcurrentMap();
    private static final Map<String, ConstructorAccess> constructorAccessCache = Maps.newConcurrentMap();

    public static <S, T> T copyAndGet(S source, T target) {
        if (source == null) {
            return null;
        }
        copy(source, target);
        return target;
    }

    public static <S, T> void copy(S source, T target) {
        if (source == null) {
            return;
        }
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        BeanCopier beanCopier = fromCacheOrCreate(sourceClass, targetClass);
        beanCopier.copy(source, target, null);
    }

    public static <S, T> T copy(S source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        ConstructorAccess<T> constructorAccess = fromCacheOrCreate(targetClass);
        T target = constructorAccess.newInstance();
        return copyAndGet(source, target);
    }

    public static <S, T> List<T> copy(List<S> sourceList, Class<T> targetClass) {
        if (sourceList == null || sourceList.isEmpty()) {
            return new ArrayList<>();
        }
        List<T> targetList = new ArrayList<>(sourceList.size());
        for (S item : sourceList) {
            targetList.add(copy(item, targetClass));
        }
        return targetList;
    }

    private static BeanCopier fromCacheOrCreate(Class<?> sourceClass, Class<?> targetClass) {
        String cacheKey = getBeanCopierCacheKey(sourceClass, targetClass);
        if (BeanCopierCache.containsKey(cacheKey)) {
            return BeanCopierCache.get(cacheKey);
        }
        BeanCopier beanCopier = BeanCopier.create(sourceClass, targetClass, false);
        BeanCopierCache.put(cacheKey, beanCopier);
        return beanCopier;
    }

    private static String getBeanCopierCacheKey(Class<?> sourceClass, Class<?> targetClass) {
        return sourceClass.toString() + CacheKeySplitter + targetClass.toString();
    }

    private static <T> ConstructorAccess<T> fromCacheOrCreate(Class<T> targetClass) {
        String cacheKey = getConstructorAccessCacheKey(targetClass);
        if (constructorAccessCache.containsKey(cacheKey)) {
            return constructorAccessCache.get(cacheKey);
        }
        ConstructorAccess<T> constructorAccess = ConstructorAccess.get(targetClass);
        constructorAccessCache.put(cacheKey, constructorAccess);
        return constructorAccess;
    }

    private static String getConstructorAccessCacheKey(Class<?> clazz) {
        return clazz.toString();
    }

}
