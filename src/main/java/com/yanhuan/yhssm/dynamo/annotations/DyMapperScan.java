package com.yanhuan.yhssm.dynamo.annotations;

import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MapperScannerRegistrar.class)
public @interface DyMapperScan {

    String[] value() default {};

    String[] basePackages() default {};

    Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;

    Class<? extends Annotation> annotationClass() default Annotation.class;

    Class<? extends MapperFactoryBean> factoryBean() default MapperFactoryBean.class;
}
