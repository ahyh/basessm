package designPattern.test.responsibilityChain;

import designPattern.test.responsibilityChain.operater.*;
import org.junit.Test;

import java.util.Date;

/**
 * 责任链模式测试方法
 */
public class ResponsibilityTest {

    /**
     * 此处设置一个执行链，
     * 一般在实际项目中可能是把多个处理者注入到Spring容器中
     * 在通过注入bean的方式组织起执行链，这样代码就不需要修改
     * 只是需要修改配置文件就OK了
     */
    private Manager bossManager = new BossManager("daBoss", null);
    private Manager hrManager = new HRManager("wangzong", bossManager);
    private Manager departmentManager = new DepartmentManager("laoli",hrManager);
    private Manager groupLeaderManager = new GroupLeaderManager("xiaozhang", departmentManager);


    @Test
    public void test() {
        Apply apply = new Apply();
        apply.setId(1l);
        apply.setApplyType((byte)1);
        apply.setApplyStatus((byte)0);
        apply.setApplier("yudaijing");
        apply.setApplyReason("没事干，就是想请个假！");
        apply.setApplyTime(new Date());
        apply.setTimeLength(11);
        boolean b = groupLeaderManager.handleApply(apply);
        System.out.println(b);
    }

}
