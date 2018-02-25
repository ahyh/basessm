package designPattern.test.observer;

/**
 * 睡觉的学生作为观察者
 */
public class SleepStudent implements Observer {

    private String name;

    public SleepStudent(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(this + "结束睡觉");
        System.out.println(this + "好好学习");
    }

    @Override
    public String toString() {
        return "SleepStudent{" +
                "name='" + name + '\'' +
                '}';
    }
}
