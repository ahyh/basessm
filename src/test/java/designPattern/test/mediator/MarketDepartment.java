package designPattern.test.mediator;

/**
 * 市场部
 */
public class MarketDepartment extends Colleague {

    public MarketDepartment(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMsg(String msg) {
        System.out.println("MarketDepartment send:" + msg);
    }

    @Override
    public void execute(String msg) {
        System.out.println("MarketDepartment execute:" + msg);
    }

    public String toString() {
        return "MarketDepartment";
    }
}
