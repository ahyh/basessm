package designPattern.test.factory.simple.factory;

import designPattern.test.factory.simple.Factory;
import designPattern.test.factory.simple.product.BasePhone;

/**
 * 手机工厂
 */
public abstract class PhoneFactory implements Factory<BasePhone> {

    /**
     * 获取Factory方法
     */
    public static Factory getFactory(Class clazz) {
        Factory factory = null;
        try {
            factory = (Factory) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

}
