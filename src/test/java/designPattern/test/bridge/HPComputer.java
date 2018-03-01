package designPattern.test.bridge;

/**
 * 惠普电脑
 */
public class HPComputer extends Computer {

    public HPComputer(OperSystem operSystem) {
        super(operSystem);
    }

    //惠普电脑扩展的方法
    public void hpComputer() {
        System.out.println("HPComputer manageFile start....");
        manageFile();
        System.out.println("HPComputer manageFile end....");
    }
}
