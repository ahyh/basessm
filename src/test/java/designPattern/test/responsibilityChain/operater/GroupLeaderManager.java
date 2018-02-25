package designPattern.test.responsibilityChain.operater;

import com.google.common.base.Preconditions;
import designPattern.test.responsibilityChain.Apply;

/**
 * 小组长管理者
 */
public class GroupLeaderManager extends Manager {

    public GroupLeaderManager() {
    }

    public GroupLeaderManager(String name, Manager next) {
        super(name, next);
    }

    /**
     * 小组长处理申请方法
     */
    @Override
    public boolean handleApply(Apply apply) {
        Preconditions.checkNotNull(apply);
        Preconditions.checkArgument(apply.getApplyStatus() != (byte) 1, "The apply:" + apply.getId() + "is already operated!");
        if (apply.getTimeLength() > 0 && apply.getTimeLength() <= 2) {
            return operateApply(apply);
        }
        //小组长没有权限处理交给下一个处理者
        System.out.println("GroupLeader has no authorization to handler the apply");
        return getNext().handleApply(apply);
    }

}
