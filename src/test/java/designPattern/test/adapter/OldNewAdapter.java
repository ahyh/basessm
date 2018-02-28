package designPattern.test.adapter;

import designPattern.test.adapter.impl.NewImpl;
import designPattern.test.adapter.interf.OldInterface;

/**
 * 适配器，将需要适配的接口或类作为构造器参数传入
 */
public class OldNewAdapter extends NewImpl {

    private OldInterface oldInterface;

    public OldNewAdapter(OldInterface oldInterface) {
        this.oldInterface = oldInterface;
    }

    @Override
    public void newMethod() {
        super.newMethod();
    }

    public void oldMethod() {
        oldInterface.oldMethod();
    }

}
