package com.yanhuan.yhssm.dynamo.annotations;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DyMethod {

    String value() default "";

    String table() default "";

    DyIndexDesc index();
}
