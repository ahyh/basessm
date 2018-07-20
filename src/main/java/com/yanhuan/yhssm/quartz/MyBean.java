package com.yanhuan.yhssm.quartz;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {

    public void printMessge() {
        System.out.println("MyBean executes!");
    }

}
