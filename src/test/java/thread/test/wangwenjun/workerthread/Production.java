package thread.test.wangwenjun.workerthread;

/**
 * 产品类
 *
 * @author yanhuan1
 */
public class Production extends InstructionBook {

    private final Integer productionId;

    public Production(Integer productionId) {
        this.productionId = productionId;
    }

    @Override
    public void firstProcess() {
        System.out.println("execution the " + productionId + "first process!");
    }

    @Override
    public void secondProcess() {
        System.out.println("execution the " + productionId + "second process!");
    }
}
