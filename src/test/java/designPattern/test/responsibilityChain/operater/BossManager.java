package designPattern.test.responsibilityChain.operater;

import com.google.common.base.Preconditions;
import designPattern.test.responsibilityChain.Apply;

import java.util.Date;

/**
 * 大Boss处理
 */
public class BossManager extends Manager {

    public BossManager() {
    }

    public BossManager(String name, Manager next) {
        super(name, next);
    }

    /**
     * 大Boss处理逻辑，大Boss必须给出终极处理，否则没人处理了
     */
    @Override
    public boolean handleApply(Apply apply) {
        Preconditions.checkNotNull(apply);
        Preconditions.checkArgument(apply.getApplyStatus() != (byte) 1, "The apply:" + apply.getId() + "is already operated!");
        if (apply.getTimeLength() > 15 && apply.getTimeLength() <= 30) {
            return operateApply(apply);
        } else {
            //给你放10000天假，你辞职吧
            apply.setTimeLength(100000);
            apply.setApplyStatus((byte) 1);
            apply.setOperateTime(new Date());
            System.out.println(apply);
        }
        return true;
    }

}
