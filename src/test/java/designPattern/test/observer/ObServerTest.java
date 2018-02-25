package designPattern.test.observer;

import org.junit.Test;

/**
 * 观察者模式测试
 */
public class ObServerTest {

    @Test
    public void testObserver() {
        Subject teacher = new Teacher();
        Subject schoolmaster = new SchoolMaster();
        Observer playStudent = new PlayStudent("小强");
        TalkStudent talkStudent1 = new TalkStudent("小红");
        TalkStudent talkStudent2 = new TalkStudent("小静");
        talkStudent1.setTalkStudent(talkStudent2);
        talkStudent2.setTalkStudent(talkStudent1);
        Observer sleepStudent = new SleepStudent("小花");
        teacher.addObserver(playStudent);
        teacher.addObserver(talkStudent1);
        teacher.addObserver(talkStudent2);
        teacher.addObserver(sleepStudent);
        schoolmaster.addObserver(playStudent);
        schoolmaster.addObserver(talkStudent1);
        schoolmaster.addObserver(talkStudent2);
        schoolmaster.addObserver(sleepStudent);
        teacher.advice();
        schoolmaster.advice();
    }

}
