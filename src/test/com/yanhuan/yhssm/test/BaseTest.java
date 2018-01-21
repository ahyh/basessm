package com.yanhuan.yhssm.test;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-main.xml"})
public class BaseTest {

    private static Logger logger = LogManager.getLogger(BaseTest.class);

    protected void print(Object result) {
        if (result == null) {
            logger.info("result is null!");
            return;
        }
        if (result instanceof List) {
            printList((List<Object>) result);
            return;
        }
        if (result instanceof Map) {
            printMap((Map<Object, Object>) result);
            return;
        }
        printObject(result);
    }

    protected <T> void printList(List<T> source) {
        if (source == null || source.size() == 0) {
            logger.info("source is empty!");
            return;
        }
        int size = source.size();
        logger.info("list size: " + size);
        for (int i = 0; i < size; i++) {
            T item = source.get(i);
            logger.info("item{} - > {}", i + 1, JSON.toJSONString(item));
        }
    }

    protected <K, V> void printMap(Map<K, V> source) {
        if (source == null || source.size() == 0) {
            logger.info("source is empty!");
            return;
        }
        logger.info("map size: " + source.size());
        for (K key : source.keySet()) {
            logger.info("key->" + key + ",value->" + JSON.toJSONString(source.get(key)));
        }
    }

    protected void printObject(Object o) {
        if (o == null) {
            logger.info("object is null!");
            return;
        }
        logger.info("result: " + JSON.toJSONString(o));
    }

}
