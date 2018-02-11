package designPattern.test.adapter;

import designPattern.test.adapter.impl.OldImpl;
import org.junit.Test;

/**
 * 测试类
 */
public class TestAdapter {

    @Test
    public void testAdapter(){
        OldNewAdapter adapter = new OldNewAdapter(new OldImpl());
        adapter.oldMethod();
        adapter.newMethod();
    }
}
