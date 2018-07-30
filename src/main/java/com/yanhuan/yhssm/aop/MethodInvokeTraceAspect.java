package com.yanhuan.yhssm.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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

    private static Logger log = LoggerFactory.getLogger(MethodAspect.class);

    //方法上加注解@MethodInvokeTraceAspect，将被拦截
    @Pointcut("@annotation(com.yanhuan.yhssm.annotations.MethodInvokeTrace ))")
    public void operateAspectByAnnotation() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param pjp 切点
     */
    @Around("operateAspectByAnnotation()")
    public Object doRound(ProceedingJoinPoint pjp) throws Throwable{
        long begin = System.nanoTime();
        Object[] args = pjp.getArgs();
        Object proceed = pjp.proceed(args);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            for (StackTraceElement stackTraceElement : entry.getValue()) {
                System.out.println(stackTraceElement);
                log.error(stackTraceElement.toString());
            }
        }
        long end = System.nanoTime();
        log.error("{}:{}", pjp.getTarget().getClass() + "." + pjp.getSignature().getName(), (end - begin) / 1000000 + "ms");
        return proceed;
    }
}
