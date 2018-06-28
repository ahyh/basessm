package designPattern.test.bridge;

import java.io.Serializable;

/**
 * 计算机类
 */
public class Computer implements Serializable {

    //操作系统
    private OperSystem operSystem;

    public Computer(OperSystem operSystem) {
        this.operSystem = operSystem;
    }

    //管理文件功能
    public void manageFile() {
        operSystem.manageFile();
    }

    //进程调度
    public void manageProcess() {
        operSystem.manageProcess();
    }

    //设备管理
    public void manageDevice() {
        operSystem.manageDevice();
    }

    //存储管理
    public void manageStorage() {
        operSystem.manageStorage();
    }

    //作业管理
    public void manageTask() {
        operSystem.manageTask();
    }

    //电脑在工作
    public void working() {
        manageProcess();
        manageFile();
        manageDevice();
        manageTask();
        manageStorage();
    }
}
