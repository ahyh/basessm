package designPattern.test.factory.simple.product;

/**
 * 手机接口
 */
public interface Phone {

    /**
     * 手机可以打电话
     */
    void call(String name);

    /**
     * 手机可以发短信
     */
    void sendMessage(String name,String message);

}
