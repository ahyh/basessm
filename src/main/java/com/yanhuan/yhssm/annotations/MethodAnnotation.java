package com.yanhuan.yhssm.annotations;

import java.lang.annotation.*;

/**
 * 注解，用于AOP切方法
 * Created by yanhuan1 on 2018/1/21.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodAnnotation {
}
