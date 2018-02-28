package designPattern.test.mediator;

import org.junit.Test;

/**
 * 测试中介者模式
 */
public class MediatorTest {

    @Test
    public void testMediator() {
        Boss boss = new Boss();
        DevDepartment devDepartment = new DevDepartment(boss);
        boss.setDevDepartment(devDepartment);
        HRDepartment hrDepartment = new HRDepartment(boss);
        boss.setHrDepartment(hrDepartment);
        MarketDepartment marketDepartment = new MarketDepartment(boss);
        boss.setMarketDepartment(marketDepartment);
        FinanDepartment finanDepartment = new FinanDepartment(boss);
        boss.setFinanDepartment(finanDepartment);

        boss.receiveMsg(devDepartment,"研发部需要加人");
        boss.sendMsg(hrDepartment,"研发部需要加人");

        boss.receiveMsg(hrDepartment,"发布招聘公告，招研发");
        boss.sendMsg(finanDepartment,"准备工资");
    }
}
