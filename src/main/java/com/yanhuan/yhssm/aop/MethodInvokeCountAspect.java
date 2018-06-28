package com.yanhuan.yhssm.aop;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 方法AOP，用于切加Controller注解的类中加MethodAnnotation注解的方法
 * Created by yanhuan1 on 2018/1/24.
 */
@Aspect
@Component
public class MethodInvokeCountAspect {

    private Multiset<String> multiset = HashMultiset.create();

    //定义为Controller的类将被拦截
    @Pointcut("within(@com.yanhuan.yhssm.annotations.ClassInvokeCount *) ")
    public void controllerAspect() {
    }

    //方法上加注解@UserRolePermission，将被拦截
    @Pointcut("@annotation(com.yanhuan.yhssm.annotations.MethodInvokeCount ))")
    public void operateAspectByAnnotation() {
    }

    @Before("operateAspectByAnnotation()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        multiset.add(methodName);
        System.out.println("=====================================");
        multiset.forEach(System.out::println);
    }

    public Multiset<String> getMultiset() {
        return multiset;
    }

    public void setMultiset(Multiset<String> multiset) {
        this.multiset = multiset;
    }
}
