package designPattern.test.observer;

/**
 * 玩的学生作为观察者
 */
public class PlayStudent implements Observer {

    private String name;

    public PlayStudent(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(this + "结束玩耍");
        System.out.println(this + "好好学习");
    }

    @Override
    public String toString() {
        return "PlayStudent{" +
                "name='" + name + '\'' +
                '}';
    }
}
