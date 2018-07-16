package com.yanhuan.yhssm.annotations;

import java.lang.annotation.*;

/**
 * 注解用于AOP切方法，统计方法调用次数
 * Created by yanhuan1 on 2018/1/21.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodInvokeDuration {
}
