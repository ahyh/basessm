package designPattern.test.adapter.impl;

import designPattern.test.adapter.interf.OldInterface;

/**
 * 老接口的实现，被适配的类
 */
public class OldImpl implements OldInterface {

    @Override
    public void oldMethod() {
        System.out.println("This is a OldInterface,old method!");
    }

}
