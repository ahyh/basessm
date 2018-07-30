package com.yanhuan.yhssm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 方法AOP，用于切加Controller注解的类中加MethodAnnotation注解的方法
 * Created by yanhuan1 on 2018/1/24.
 */
@Aspect
@Component
public class MethodAspect {

    private static Logger log = LoggerFactory.getLogger(MethodAspect.class);

    //定义为Controller的类将被拦截
    @Pointcut("within(@org.springframework.stereotype.Controller *) ")
    public void controllerAspect() {
    }

    //方法上加注解@UserRolePermission，将被拦截
    @Pointcut("@annotation(com.yanhuan.yhssm.annotations.MethodAnnotation ))")
    public void operateAspectByAnnotation() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        Class<?> aClass = joinPoint.getTarget().getClass();
        String name = aClass.getName();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURI();
        System.out.print("url:" + url);
        log.error(name + url);
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Around("operateAspectByAnnotation()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURI();
        log.error(url);
        Object[] args = joinPoint.getArgs(); // 方法的参数
        return joinPoint.proceed(args);
    }


}
