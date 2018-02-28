package designPattern.test.responsibilityChain.operater;

import com.google.common.base.Preconditions;
import designPattern.test.responsibilityChain.Apply;

import java.util.Date;

/**
 * 部门经理处理
 */
public class DepartmentManager extends Manager {

    public DepartmentManager() {
    }

    public DepartmentManager(String name, Manager next) {
        super(name, next);
    }

    /**
     * 部门经理处理逻辑
     */
    @Override
    public boolean handleApply(Apply apply) {
        Preconditions.checkNotNull(apply);
        Preconditions.checkArgument(apply.getApplyStatus() != (byte) 1, "The apply:" + apply.getId() + "is already operated!");
        if (apply.getTimeLength() > 2 && apply.getTimeLength() <= 7) {
            return operateApply(apply);
        }
        //部门经理没有权限处理交给下一个处理者
        System.out.println("DepartmentManager has no authorization to handle the apply!");
        return getNext().handleApply(apply);
    }

}
