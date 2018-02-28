package designPattern.test.observer;

/**
 * 通知者接口
 */
public interface Subject {

    //添加观察者方法
    void addObserver(Observer observer);

    //取出观察者方法
    void delObserver(Observer observer);

    //通知方法
    void advice();
}
