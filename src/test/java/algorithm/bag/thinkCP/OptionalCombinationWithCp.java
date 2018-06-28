package algorithm.bag.thinkCP;

import java.util.List;

/**
 * 查找集合
 */
public interface OptionalCombinationWithCp<T> {

    /**
     * 查找满足条件的集合
     *
     * @param detailList    初始集合,里面的元素有qty这个字段,表示数量
     * @param needQty 需要的数量
     * @param cpQty   零拣区的数量
     * @return 优先出list中的集合, 保证元素的sum(qty)=needQty,如果没有的话,优先清空储位,缺少的数量从零拣区出
     * 零捡区如果也不够在动list中的元素中找
     */
    List<T> findOptional(List<T> detailList, Integer needQty, Integer cpQty);
}
