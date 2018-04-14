package algorithm.bag.thinkCP;

import algorithm.bag.Detail;
import com.google.common.base.Preconditions;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 优先清空储位
 */
public class OptionalCombinationWithCpImpl implements OptionalCombinationWithCp<Detail> {

    /**
     * 具体实现
     *
     * @param detailList 初始集合,里面的元素有qty这个字段,表示数量
     * @param needQty    需要的数量
     * @param cpQty      零拣区的数量
     * @return
     */
    @Override
    public List<Detail> findOptional(List<Detail> detailList, Integer needQty, Integer cpQty) {
        checkParam(detailList, needQty, cpQty);
        //按数量排序
        Collections.sort(detailList, (left, right) -> left.getQty().compareTo(right.getQty()));
        //1-需求数量小于零拣区,不从detailList中出
        List<Detail> newList = new ArrayList<>();
        if (needQty < cpQty) {
            return null;
        }
        //2-从list中先出小的
        int i = 0;
        while (needQty > 0) {
            needQty -= detailList.get(i).getQty();
            newList.add(detailList.get(i++));
        }
        if (needQty == 0) {
            return newList;
        } else if (needQty < 0) {
            Detail remove = newList.remove(newList.size() - 1);
            needQty += remove.getQty();
            i--;
        }
        if (needQty < cpQty) {
            return newList;
        } else {
            newList.add(detailList.get(i));
            return newList;
        }
    }

    /**
     * 校验参数
     */
    private void checkParam(List<Detail> detailList, Integer needQty, Integer cpQty) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(detailList), "输入的数据不能为空!");
        Preconditions.checkArgument(needQty != null, "需求数量不能为空");
        Preconditions.checkArgument(needQty > 0, "需求数量必须大于0");
        Preconditions.checkArgument(cpQty > 0, "零拣区数量必须大于0");
        Integer sum = 0;
        for (Detail detail : detailList) {
            sum += detail.getQty();
        }
        Preconditions.checkArgument(needQty < sum, "需求数量必须小于保管位数量之和");
        Preconditions.checkArgument(cpQty < needQty, "零拣区数量小于需求数量");
    }
}
