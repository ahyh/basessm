package designPattern.test.iterator;

/**
 * 迭代器接口
 */
public interface Iterator<T> {

    /**
     * 是否有下一个元素
     */
    boolean hasNext();

    /**
     * 返回下一个元素
     */
    T next();
}
