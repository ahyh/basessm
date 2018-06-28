package designPattern.test.bridge;

/**
 * Windows操作系统类
 */
public class Windows extends OperSystem {

    public Windows(String version) {
        super(version);
    }

    @Override
    void manageFile() {
        System.out.println("Windows " + this.getVersion() + " manageFile......");
    }

    @Override
    void manageProcess() {
        System.out.println("Windows " + this.getVersion() + "  manageProcess......");
    }

    @Override
    void manageDevice() {
        System.out.println("Windows  " + this.getVersion() + " manageDevice......");
    }

    @Override
    void manageStorage() {
        System.out.println("Windows " + this.getVersion() + "  manageStorage......");
    }

    @Override
    void manageTask() {
        System.out.println("Windows " + this.getVersion() + "  manageTask......");
    }
}
