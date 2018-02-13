package designPattern.test.proxy.dynamic;

/**
 * 租房代理
 */
public class RenterProxy implements Renting{

    private Renter renter;

    public RenterProxy(Renter renter) {
        this.renter = renter;
    }

    /**
     * 租房代理租房
     */
    @Override
    public void renting(String apply) {
        System.out.println("RenterProxy renting-apply:" + apply);
    }

    /**
     * 实际租房人自己付房租
     */
    @Override
    public void pay(Double money) {
        renter.pay(money);
    }
}
