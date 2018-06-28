package designPattern.test.bridge;

/**
 * Created by yanhuan1 on 2018/2/27.
 */
public class Linux extends OperSystem {

    public Linux(String version) {
        super(version);
    }

    @Override
    void manageFile() {
        System.out.println("Linux " + this.getVersion() + " manageFile......");
    }

    @Override
    void manageProcess() {
        System.out.println("Linux " + this.getVersion() + "  manageProcess......");
    }

    @Override
    void manageDevice() {
        System.out.println("Linux  " + this.getVersion() + " manageDevice......");
    }

    @Override
    void manageStorage() {
        System.out.println("Linux " + this.getVersion() + "  manageStorage......");
    }

    @Override
    void manageTask() {
        System.out.println("Linux " + this.getVersion() + "  manageTask......");
    }
}
