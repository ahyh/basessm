package designPattern.test.mediator;

/**
 * 财务部
 */
public class FinanDepartment extends Colleague {

    public FinanDepartment(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMsg(String msg) {
        System.out.println("FinanDepartment send" + msg);
    }

    @Override
    public void execute(String msg) {
        System.out.println("FinanDepartment execute" + msg);
    }

    public String toString() {
        return "FinanDepartment";
    }
}
