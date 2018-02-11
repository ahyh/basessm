package designPattern.test.adapter.impl;

import designPattern.test.adapter.interf.NewInterface;

/**
 * 新接口
 */
public class NewImpl implements NewInterface {

    @Override
    public void newMethod() {
        System.out.println("This is a NewImpl newMethod");
    }

}
