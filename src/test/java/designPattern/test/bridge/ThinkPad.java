package designPattern.test.bridge;

/**
 * ThinkPad电脑
 */
public class ThinkPad extends Computer {

    public ThinkPad(OperSystem operSystem) {
        super(operSystem);
    }

    //从Computer类功能扩展来的方法
    public void thinkPad() {
        System.out.println("ThinkPad manangeProcess start....");
        manageProcess();
        System.out.println("ThinkPad manangeProcess end....");
    }
}
