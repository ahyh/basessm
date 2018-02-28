package designPattern.test.mediator;

/**
 * 中介者接口
 */
public interface Mediator {

    //接收消息方法
    void receiveMsg(Colleague sender, String msg);

    //发送消息方法
    void sendMsg(Colleague receiver, String msg);
}
