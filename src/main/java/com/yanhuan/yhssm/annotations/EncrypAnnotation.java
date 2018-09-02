package com.yanhuan.yhssm.annotations;

import java.lang.annotation.*;

/**
 * 注解,给MyBatis拦截器使用，将需要加密的属性上加此注解可以实现加密解密
 * Created by yanhuan1 on 2018/1/21.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER, ElementType.FIELD})
public @interface EncrypAnnotation {
}
