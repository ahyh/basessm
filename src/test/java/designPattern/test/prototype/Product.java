package designPattern.test.prototype;

import java.io.Serializable;

/**
 * 产品接口，继承于Cloneable
 */
public interface Product extends Cloneable, Serializable {

    //使用方法
    void use(String s);

    //创建克隆对象方法
    Product createClone();
}
