package com.yanhuan.yhssm.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 方法执行时间AOP统计
 */
public class MethodInvokeDurationAspect {

    private static final Logger logger = LogManager.getLogger(MethodInvokeDurationAspect.class);

    /**
     * 环绕通知用于统计方法的执行时间
     *
     * @param pjp 切入点
     * @return 方法返回值
     * @throws Throwable 抛出的异常信息
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.nanoTime();
        Object[] args = pjp.getArgs();
        Object proceed = pjp.proceed(args);
        long end = System.nanoTime();
        logger.error("{}:{}", pjp.getTarget().getClass() + "." + pjp.getSignature().getName(), (end - begin) / 1000000 + "ms");
        return proceed;
    }
}
