package designPattern.test.factory.simple.factory;

import designPattern.test.factory.simple.product.ApplePhone;
import designPattern.test.factory.simple.product.BasePhone;

/**
 * Apple手机工厂
 */
public class ApplePhoneFactory extends PhoneFactory {

    /**
     * 生产具体的ApplePhone产品，如果需要对ApplePhone进行统一的初始化操作
     * 可以都定义在这里，项目中就不需要在重复初始化了
     */
    @Override
    public BasePhone create() {
        return new ApplePhone(155, 88, 9.1, "golden");
    }

}
