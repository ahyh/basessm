package com.yanhuan.yhssm.aop;

import com.yanhuan.yhssm.annotations.PropAnnotation;
import com.yanhuan.yhssm.dao.OrderMainDao;
import com.yanhuan.yhssm.domain.pojo.OrderMain;
import com.yanhuan.yhssm.utils.ReflectUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;

/**
 * 属性AOP
 * Created by yanhuan1 on 2018/1/22.
 */
@Aspect
@Component
public class PropAspect {

    @Resource
    private OrderMainDao orderMainDao;

    //定义为Controller的类 ,方法上加注解，将被拦截
    @Pointcut("execution(public * (@org.springframework.stereotype.Controller *).* (.., @com.yanhuan.yhssm.annotations.PropAnnotation (*), ..))")
    public void propSetAOP() {
    }

    @Around("propSetAOP()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        Annotation[][] annotations = joinPoint.getTarget().getClass().getMethod(methodName, parameterTypes).getParameterAnnotations();
        Object[] args = joinPoint.getArgs(); // 方法的参数
        OrderMain orderMain = orderMainDao.get(6l);
        if (annotations != null) {
            for (int i = 0; i < annotations.length; i++) {
                Annotation[] annos = annotations[i];
                for (int j = 0; j < annos.length; j++) {
                    Annotation anno = annos[j];
                    if (anno.annotationType().equals(PropAnnotation.class)) {
                        PropAnnotation propAnnotation = (PropAnnotation) anno;
                        String provinceNo = propAnnotation.provinceNo();
                        String cityNo = propAnnotation.cityNo();
                        String storeNo = propAnnotation.storeNo();
                        Object paramObj = args[i];
                        Class<?> parameterClass = parameterTypes[i];
                        try {
                            if (null != orderMain) {
                                ReflectUtil.assignField(parameterClass, true, paramObj, provinceNo, orderMain.getProvinceNo().toString());
                                ReflectUtil.assignField(parameterClass, true, paramObj, cityNo, orderMain.getCityNo().toString());
                                ReflectUtil.assignField(parameterClass, true, paramObj, storeNo, orderMain.getStoreNo().toString());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return joinPoint.proceed(args);
    }
}
