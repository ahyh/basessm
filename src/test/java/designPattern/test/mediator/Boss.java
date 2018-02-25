package designPattern.test.mediator;

/**
 * 大老板就是中介者
 */
public class Boss implements Mediator {

    private HRDepartment hrDepartment;

    private DevDepartment devDepartment;

    private MarketDepartment marketDepartment;

    private FinanDepartment finanDepartment;

    public HRDepartment getHrDepartment() {
        return hrDepartment;
    }

    public void setHrDepartment(HRDepartment hrDepartment) {
        this.hrDepartment = hrDepartment;
    }

    public DevDepartment getDevDepartment() {
        return devDepartment;
    }

    public void setDevDepartment(DevDepartment devDepartment) {
        this.devDepartment = devDepartment;
    }

    public MarketDepartment getMarketDepartment() {
        return marketDepartment;
    }

    public void setMarketDepartment(MarketDepartment marketDepartment) {
        this.marketDepartment = marketDepartment;
    }

    public FinanDepartment getFinanDepartment() {
        return finanDepartment;
    }

    public void setFinanDepartment(FinanDepartment finanDepartment) {
        this.finanDepartment = finanDepartment;
    }

    @Override
    public void receiveMsg(Colleague sender, String msg) {
        System.out.println("同事：" + sender.toString() + "发送消息：" + msg);
        sender.sendMsg(msg);
    }

    @Override
    public void sendMsg(Colleague receiver, String msg) {
        System.out.println("同事：" + receiver.toString() + "执行消息：" + msg);
        receiver.execute(msg);
    }
}
