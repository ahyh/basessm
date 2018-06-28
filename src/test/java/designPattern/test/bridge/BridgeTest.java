package designPattern.test.bridge;

import org.junit.Test;

/**
 * 桥接模式测试
 */
public class BridgeTest {

    @Test
    public void testBridge() {
        Computer thinkPad = new ThinkPad(new Windows("Win7"));
        Computer hp = new HPComputer(new Linux("CentOS 7.0"));
        thinkPad.working();
        hp.working();
        ThinkPad thinkPad1 = new ThinkPad(new Linux("CentOS 6.8"));
        HPComputer hpComputer = new HPComputer(new Windows("Win10"));
        thinkPad1.thinkPad();
        hpComputer.hpComputer();
    }
}
