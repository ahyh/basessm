package designPattern.test.observer;

/**
 * 聊天的学生作为观察者
 */
public class TalkStudent implements Observer {

    private String name;

    private TalkStudent talkStudent;

    public TalkStudent(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(this.getName() + "结束和" + talkStudent.getName() + "的聊天");
        System.out.println(this.getName() + "好好学习");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TalkStudent getTalkStudent() {
        return talkStudent;
    }

    public void setTalkStudent(TalkStudent talkStudent) {
        this.talkStudent = talkStudent;
    }
}
