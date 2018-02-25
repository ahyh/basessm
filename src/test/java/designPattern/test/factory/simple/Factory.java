package designPattern.test.factory.simple;

/**
 * 工厂接口，还不确定生产的产品，定义成泛型接口
 * 生产类型为T的产品
 */
public interface Factory<T> {

    T create();

}
