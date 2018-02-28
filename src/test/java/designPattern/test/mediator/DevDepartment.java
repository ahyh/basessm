package designPattern.test.mediator;

/**
 * 研发部
 */
public class DevDepartment extends Colleague {

    public DevDepartment(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMsg(String msg) {
        System.out.println("DevDepartment send:" + msg);
    }

    @Override
    public void execute(String msg) {
        System.out.println("DevDepartment execute:" + msg);
    }

    public String toString() {
        return "DevDepartment";
    }
}
