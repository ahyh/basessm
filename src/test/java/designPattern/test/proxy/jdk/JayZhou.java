package designPattern.test.proxy.jdk;

/**
 * Singer具体的实现类
 */
public class JayZhou implements Singer {

    @Override
    public void confer() {
        System.out.println("JayZhou confer");
    }

    @Override
    public void signContext() {
        System.out.println("JayZhou signContext");
    }

    @Override
    public void bookTicket() {
        System.out.println("JayZhou bookTicket");
    }

    /**
     * 只有这一步是JayZhou自己来的，其他的步骤都应交给代理类执行
     */
    @Override
    public void sing() {
        System.out.println("JayZhou sing");
    }

    @Override
    public void collectMoney() {
        System.out.println("JayZhou collectMoney");
    }

}
