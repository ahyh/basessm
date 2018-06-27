package com.yanhuan.yhssm.test;

import com.yanhuan.yhssm.domain.pojo.TestIn;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-test-*.xml");
        TestIn testIn = (TestIn)applicationContext.getBean("testIn");
        System.out.println(testIn.getAge());
    }


}
