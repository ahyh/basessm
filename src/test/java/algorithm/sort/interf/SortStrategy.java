package algorithm.sort.interf;

import java.util.List;

/**
 * 排序接口
 */
public interface SortStrategy {

    /**
     * 插入排序方法
     */
    void insertSort(List<Comparable> list);
}
