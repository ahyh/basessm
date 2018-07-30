package com.yanhuan.yhssm.annotations;

import java.lang.annotation.*;

/**
 * 注解用于AOP切方法，用于获取方法的调用栈信息
 * Created by yanhuan1 on 2018/1/21.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodInvokeTrace {
}
