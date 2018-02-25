package designPattern.test.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 校长作为通知者
 */
public class SchoolMaster implements Subject {

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
        System.out.println("校长发出通知");
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
