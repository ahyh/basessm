package com.yanhuan.yhssm.dynamo.annotations;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DyIndexDesc {

    boolean primary() default false;

    String indexName() default "";

    String hashKey() default "";

    String sortKey() default "";
}
