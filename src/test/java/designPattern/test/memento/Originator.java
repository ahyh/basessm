package designPattern.test.memento;

/**
 * 备忘录模式，备忘对象生成者
 */
public interface Originator {

    //捕获当前状态并保存在MementoHandler
    void createMemento();

    //撤销，返回对象上一个保存的状态
    void undo();
}
