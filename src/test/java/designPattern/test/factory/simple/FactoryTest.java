package designPattern.test.factory.simple;

import designPattern.test.factory.simple.factory.ApplePhoneFactory;
import designPattern.test.factory.simple.factory.HuaWeiPhoneFactory;
import designPattern.test.factory.simple.factory.PhoneFactory;
import designPattern.test.factory.simple.product.Phone;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂模式测试
 */
public class FactoryTest {

    private static final String APPLEPHONE = "applePhone";
    private static final String HUAWEIPHONE = "huaweiPhone";

    /**
     * 工厂集合
     */
    private static Map<String, Factory> factoryMap = new HashMap<>();

    /**
     * 初始化工厂放入集合中
     */
    static {
        Factory applePhoneFactory = PhoneFactory.getFactory(ApplePhoneFactory.class);
        Factory huaweiPhoneFactory = PhoneFactory.getFactory(HuaWeiPhoneFactory.class);
        factoryMap.put(APPLEPHONE, applePhoneFactory);
        factoryMap.put(HUAWEIPHONE, huaweiPhoneFactory);
    }

    /**
     * 生产ApplePhone,打电话发短信
     */
    @Test
    public void testApplePhone() {
        Factory factory = factoryMap.get(APPLEPHONE);
        callAndSendMsg(factory, "yudaijing", "HelloWorld");
    }

    /**
     * 生产ApplePhone,打电话发短信
     */
    @Test
    public void testHuaWeiPhone() {
        Factory factory = factoryMap.get(HUAWEIPHONE);
        callAndSendMsg(factory, "yudaijing", "HelloWorld");
    }

    /**
     * 工厂生产出手机后就打电话发短信
     * @param factory
     * @param name
     * @param msg
     */
    private void callAndSendMsg(Factory factory, String name, String msg) {
        Phone phone = (Phone) factory.create();
        phone.call(name);
        phone.sendMessage(name, msg);
    }

}
