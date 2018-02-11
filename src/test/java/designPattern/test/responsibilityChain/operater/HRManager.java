package designPattern.test.responsibilityChain.operater;

import com.google.common.base.Preconditions;
import designPattern.test.responsibilityChain.Apply;

/**
 * HR处理逻辑
 */
public class HRManager extends Manager {

    public HRManager() {
    }

    public HRManager(String name, Manager next) {
        super(name, next);
    }

    @Override
    public boolean handleApply(Apply apply) {
        Preconditions.checkNotNull(apply);
        Preconditions.checkArgument(apply.getApplyStatus() != (byte) 1, "The apply:" + apply.getId() + "is already operated!");
        if (apply.getTimeLength() > 7 && apply.getTimeLength() <= 15) {
            return operateApply(apply);
        }
        //HR没有权限处理交给下一个处理者
        System.out.println("HRManager has no authorization to handle the apply!");
        return getNext().handleApply(apply);
    }

}
