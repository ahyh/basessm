package designPattern.test.mediator;

/**
 * 人力资源部
 */
public class HRDepartment extends Colleague {

    public HRDepartment(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMsg(String msg) {
        System.out.println("HRDepartment send:" + msg);
    }

    @Override
    public void execute(String msg) {
        System.out.println("HRDepartment execute:" + msg);
    }

    public String toString() {
        return "HRDepartment";
    }

}
