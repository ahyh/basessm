package designPattern.test.bridge;

/**
 * 操作系统抽象类
 */
public abstract class OperSystem {

    //操作系统版本
    private String version;

    public OperSystem(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    //管理文件功能
    abstract void manageFile();

    //进程调度
    abstract void manageProcess();

    //设备管理
    abstract void manageDevice();

    //存储管理
    abstract void manageStorage();

    //作业管理
    abstract void manageTask();
}
