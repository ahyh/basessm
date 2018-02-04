package designPattern.test.factory.simple.factory;

import designPattern.test.factory.simple.product.BasePhone;
import designPattern.test.factory.simple.product.HuaWeiPhone;

/**
 * 华为手机
 */
public class HuaWeiPhoneFactory extends PhoneFactory {

    /**
     * 生产具体的HuaWeiPhone产品，如果需要对HuaWeiPhone进行统一的初始化操作
     * 可以都定义在这里，项目中就不需要在重复初始化了
     */
    @Override
    public BasePhone create() {
        return new HuaWeiPhone(155, 88, 10.2, "golden");
    }

}
