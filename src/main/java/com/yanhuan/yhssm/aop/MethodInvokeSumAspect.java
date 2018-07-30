package com.yanhuan.yhssm.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MethodInvokeSumAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodInvokeSumAspect.class);

    private Map<String, Integer> map = new HashMap<>();

    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        if (map.containsKey(methodName)) {
            map.put(methodName, map.get(methodName) + 1);
        } else {
            map.put(methodName, 1);
        }
        logger.error("Map:" + JSON.toJSON(map));
    }

}
