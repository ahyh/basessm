package designPattern.test.proxy.dynamic;

/**
 * 实际需要租房子的人
 */
public class Renter implements Renting {

    /**
     * 实际租房人租房
     */
    @Override
    public void renting(String apply) {
        System.out.println("Renter renting-apply:" + apply);
    }

    /**
     * 实际租房人付房租
     */
    @Override
    public void pay(Double money) {
        System.out.println("Renter renting-pay:" + money);
    }

}
