package designPattern.test.proxy.dynamic;

/**
 * 接口：租房子
 */
public interface Renting {

    /**
     * 找房子方法，交给代理人执行
     */
    void renting(String apply);

    /**
     * 付房租方法，自己执行
     */
    void pay(Double money);
}
