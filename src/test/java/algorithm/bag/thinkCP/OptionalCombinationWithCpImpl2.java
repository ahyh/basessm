package algorithm.bag.thinkCP;

import algorithm.bag.Detail;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class OptionalCombinationWithCpImpl2 implements OptionalCombinationWithCp<Detail> {

    /**
     * 具体实现,查询正好的
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
        Collections.sort(detailList, Comparator.comparing(Detail::getQty));
        //1-需求数量小于零拣区,不从detailList中出
        List<Detail> dList = new ArrayList<>();
        List<Detail> newList = new ArrayList<>();
        for (int i = 0; i < detailList.size(); i++) {
            if (detailList.get(i).getQty() == needQty) {
                return Lists.newArrayList(detailList.get(i));
            }
            if (detailList.get(i).getQty() > needQty) {
                dList = detailList.subList(0, i);
                break;
            }
        }
        //2-找出需要几个元素才能满足要求
        List<Detail> reverseList = Lists.reverse(dList);
        int min = 0, minNeedQty = needQty;
        int max = 0, maxNeedQty = needQty;
        while (minNeedQty > 0) {
            newList.add(reverseList.get(min));
            minNeedQty -= reverseList.get(min++).getQty();
        }
        if (minNeedQty == 0) {
            return newList;
        }
        newList.clear();
        while (maxNeedQty > 0) {
            newList.add(dList.get(max));
            maxNeedQty -= dList.get(max++).getQty();
        }
        if (maxNeedQty == 0) {
            return newList;
        }
        newList.clear();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = min; i <= (min + max) / 2; i++) {

        }

        System.out.println(dList.size());
        return null;
    }

    private boolean findDetailOptional(List<Detail> detailList, Integer needQty, Integer num) {
        List<Detail> subList = detailList.subList(0, num);
        Integer sum = getSum(subList);
        Integer diff = sum - needQty;
        return true;
    }

    private Integer getSum(List<Detail> detailList) {
        Integer sum = 0;
        for (Detail detail : detailList) {
            sum += detail.getQty();
        }
        return sum;
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
