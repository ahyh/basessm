package com.yanhuan.yhssm.annotations;

import java.lang.annotation.*;

/**
 * 注解用于AOP切方法参数，给对应登录用户的provinceNo,cityNo,storeNo赋值，的查询条件赋值
 * Created by yanhuan1 on 2018/1/21.
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PropAnnotation {

    String provinceNo() default "provinceNo";

    String cityNo() default "cityNo";

    String storeNo() default "storeNo";

}
