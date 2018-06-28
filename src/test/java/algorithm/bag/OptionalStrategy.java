package algorithm.bag;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 泛型接口实现
 */
public class OptionalStrategy implements OptionalCombination<Detail> {

    @Override
    public List<Detail> getOptional(List<Detail> detailList, Integer needQty) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(detailList), "输入的数据不能为空!");
        Preconditions.checkArgument(needQty != null, "需求数量不能为空");
        Preconditions.checkArgument(needQty > 0, "需求数量必须大于0");
        //按数量排序
        Collections.sort(detailList, (left, right) -> left.getQty().compareTo(right.getQty()));
        if (needQty <= detailList.get(0).getQty()) {
            return Lists.newArrayList(detailList.get(0));
        }
        //求和
        Integer sum = 0;
        for (Detail detail : detailList) {
            sum += detail.getQty();
        }
        if (needQty >= sum) {
            return detailList;
        }
        //否则从大到小逐渐返回
        //找出所以比needQty小的数的集合
        Detail firstMoreThanNeedQtyDetail = null;
        List<Detail> reversList = new ArrayList<>();
        for (Detail detail : detailList) {
            if (detail.getQty() <= needQty) {
                reversList.add(0, detail);
            } else {
                firstMoreThanNeedQtyDetail = detail;
                break;
            }
        }
        List<Detail> newList = new ArrayList<>();
        for (int i = 0; i < reversList.size(); i++) {
            newList.add(reversList.get(i));
            needQty -= reversList.get(i).getQty();
            if (needQty == 0) {
                return newList;
            }
            if (needQty < 0 && i != reversList.size() - 1) {
                Detail remove = newList.remove(newList.size() - 1);
                needQty += remove.getQty();
            }
        }
        //如果所有小于needQty的之后还是小于needQty那么返回比needQty大的第一个元素即可
        if (needQty > 0 && firstMoreThanNeedQtyDetail != null) {
            return Lists.newArrayList(firstMoreThanNeedQtyDetail);
        }
        return newList;
    }
}
