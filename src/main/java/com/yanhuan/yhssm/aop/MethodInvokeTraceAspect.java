package com.yanhuan.yhssm.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * AOP获取方法的调用栈信息
 *
 * @author yanhuan1
 */
@Aspect
@Component
public class MethodInvokeTraceAspect {

    private static final Logger log = LoggerFactory.getLogger(MethodAspect.class);

    /**
     * 方法上加注解@MethodInvokeTraceAspect，将被拦截
     */
    @Pointcut("@annotation(com.yanhuan.yhssm.annotations.MethodInvokeTrace ))")
    public void operateAspectByAnnotation() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @After("operateAspectByAnnotation()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().toString();
        //获取方法名
        System.out.println("MehtodName:" + methodName);
        log.error("MehtodName:" + methodName);
        Class[] parameterTypes = signature.getParameterTypes();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < parameterTypes.length; i++) {
            log.error("Parameter Type:" + parameterTypes[i].getName() + " and args:" + JSON.toJSONString(args[i]));
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            for (StackTraceElement stackTraceElement : entry.getValue()) {
                String className = stackTraceElement.getClassName();
                String methodName1 = stackTraceElement.getMethodName();
                if (className.startsWith("com.yanhuan.yhssm")) {
                    System.out.println(stackTraceElement);
                    log.error(stackTraceElement.toString());
                }
                if (methodName1.startsWith("com.yanhuan.yhssm")) {
                    System.out.println(stackTraceElement);
                    log.error(stackTraceElement.toString());
                }
            }
        }
    }
}
