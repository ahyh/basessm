package algorithm.bag;

import java.util.List;

/**
 * 泛型接口，求局部最优解
 */
public interface OptionalCombination<T> {

    /**
     * 求局部最优解
     */
    List<T> getOptional(List<T> list, Integer needQty);
}
