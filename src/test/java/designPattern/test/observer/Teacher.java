package designPattern.test.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 老师作为通知者
 */
public class Teacher implements Subject {

    //维护一个观察者的集合
    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void advice() {
        System.out.println("老师发出通知");
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
