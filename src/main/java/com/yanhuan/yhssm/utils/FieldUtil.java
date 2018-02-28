package com.yanhuan.yhssm.utils;

import com.google.common.base.Preconditions;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Field相关工具类
 * Created by yanhuan1 on 2018/1/28.
 */
public final class FieldUtil {

    /**
     * 获取clazz类型的所有的属性，包括所有父类的属性
     * @param clazz
     * @return
     */
    public static Map<String, Field> getAllName2FieldMap(Class clazz) {
        Preconditions.checkNotNull(clazz);
        Map<String, Field> map = new HashMap<>();
        Field[] fields;
        while (clazz != null) {
            fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field);
            }
            clazz = clazz.getSuperclass();
        }
        return map;
    }

}
