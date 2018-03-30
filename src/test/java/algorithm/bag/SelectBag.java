package algorithm.bag;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yanhuan1 on 2018/3/29.
 */
public class SelectBag {

    @Test
    public void testbag() {
        List<Detail> detailList = Lists.newArrayList(
                new Detail(1l, "2", 2),
                new Detail(5l, "5", 5),
                new Detail(2l, "2", 2),
                new Detail(11l, "11", 11),
                new Detail(2l, "2", 2),
                new Detail(9l, "9", 9),
                new Detail(3l, "3", 3),
                new Detail(6l, "6", 6),
                new Detail(23l, "23", 23),
                new Detail(5l, "5", 5),
                new Detail(8l, "8", 8),
                new Detail(34l, "34", 34),
                new Detail(75l, "75", 75)
        );
        List<Detail> optionalCombination = getOptionalCombination(detailList, 4);
        System.out.println(optionalCombination.size());
    }

    /**
     * 在集合detailList中找出detail.getQty()总和最接近needQty的组合
     *
     * @param detailList Detail集合，Detail中包含qty字段，用于选出最优组合
     * @param needQty    需要的数量，有一个或多个Detail实例的qty组合
     * @return
     */
    public static List<Detail> getOptionalCombination(List<Detail> detailList, Integer needQty) {
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
        List<Detail> reversList = new ArrayList<>();
        for (Detail detail : detailList) {
            if (detail.getQty() <= needQty) {
                reversList.add(0, detail);
            } else {
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
        return newList;
    }
}

class Detail {
    private Long id;
    private String name;
    private Integer qty;

    public Detail() {
    }

    public Detail(Long id, String name, Integer qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
