package algorithm.sort;

import com.google.common.base.Preconditions;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.comparators.ComparableComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序工具类
 */
public final class SortUtil {

    /**
     * 数据校验与类型转换
     *
     * @param list list中存放的是实现了Comparable接口的实例
     * @return 返回Comparable[]数组
     */
    private static Comparable[] checkAndReturnArray(final List<? extends Comparable> list) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(list), "需要排序的集合不能为空");
        Comparable[] array = new Comparable[1];
        array = list.toArray(array);
        return array;
    }

    /**
     * 插入排序，要求排序的类型实现Comparable接口
     */
    static List<? extends Comparable> insertSort(final List<? extends Comparable> list) {
        Comparable[] array = checkAndReturnArray(list);
        int len = array.length;
        int j;
        for (int i = 1; i < len; i++) {
            Comparable temp = array[i];
            for (j = i; j > 0 && temp.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        return Arrays.asList(array);
    }

    /**
     * 希尔排序
     */
    static List<? extends Comparable> shellSort(final List<? extends Comparable> list) {
        Comparable[] array = checkAndReturnArray(list);
        int len = array.length;
        int j;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                Comparable temp = array[i];
                for (j = i; j >= gap && temp.compareTo(array[j - gap]) < 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return Arrays.asList(array);
    }

    /**
     * 堆排序
     *
     * @param list
     * @return
     */
    static List<? extends Comparable> heapSort(final List<? extends Comparable> list) {
        Comparable[] array = checkAndReturnArray(list);
        int len = array.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            percDown(array, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            swapReferences(array, 0, i);
            percDown(array, 0, i);
        }
        return Arrays.asList(array);
    }

    /**
     * 交换数组中下标 i,j两个元素值
     *
     * @param array 数组
     * @param i     下标
     * @param j     下标
     */
    private static void swapReferences(Comparable[] array, int i, int j) {
        if (i == j) return;
        if (i < 0 || j < 0) return;
        if (i > array.length || j > array.length) return;
        Comparable temp;
        temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static void percDown(Comparable[] array, int i, int n) {
        int child;
        Comparable temp;
        for (temp = array[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && array[child].compareTo(array[child + 1]) < 0) {
                child++;
            }
            if (temp.compareTo(array[child]) < 0) {
                array[i] = array[child];
            } else {
                break;
            }
        }
        array[i] = temp;
    }

    /**
     * 归并排序
     *
     * @param list
     * @return
     */
    static List<? extends Comparable> mergeSort(List<? extends Comparable> list) {
        Comparable[] array = checkAndReturnArray(list);
        int len = array.length;
        Comparable[] tempArray = new Comparable[len];
        mergeSortArray(array, tempArray, 0, len - 1);
        return Arrays.asList(array);
    }

    /**
     * 归并排序
     *
     * @param array
     * @param tempArray
     * @param left
     * @param right
     */
    private static void mergeSortArray(Comparable[] array, Comparable[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSortArray(array, tempArray, left, center);
            mergeSortArray(array, tempArray, center + 1, right);
            merge(array, tempArray, left, center + 1, right);
        }
    }

    /**
     * 归并排序
     *
     * @param array
     * @param tempArray
     * @param leftPos
     * @param rightPos
     * @param rightEnd
     */
    private static void merge(Comparable[] array, Comparable[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos].compareTo(array[rightPos]) <= 0) {
                tempArray[tmpPos++] = array[leftPos++];
            } else {
                tempArray[tmpPos++] = array[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {
            tempArray[tmpPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tempArray[tmpPos++] = array[rightPos++];
        }
        for (int i = 0; i < numElements; i++, rightEnd--) {
            array[rightEnd] = tempArray[rightEnd];
        }
    }

    /**
     * 快速排序
     *
     * @param list
     * @return
     */
    static List<? extends Comparable> quickSort(List<? extends Comparable> list) {
        if (list.size() > 1) {
            List smaller = new ArrayList<>();
            List same = new ArrayList<>();
            List larger = new ArrayList<>();
            Comparable comparable = list.get(list.size() / 2);
            for (Comparable temp : list) {
                if (temp.compareTo(comparable) < 0) {
                    smaller.add(temp);
                } else if (temp.compareTo(comparable) > 0) {
                    larger.add(temp);
                } else {
                    same.add(temp);
                }
            }
            quickSort(smaller);
            quickSort(larger);

            list.clear();
            list.addAll(smaller);
            list.addAll(same);
            list.addAll(larger);
            return list;
        }
        return null;
    }


}
