package algorithm.sort;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入排序
 */
public class InsertSort {

    private static List<AnyType> list = new ArrayList<>();

    static {
        list = Lists.newArrayList(
                new AnyType(1, "aa"),
                new AnyType(3, "cc"),
                new AnyType(2, "bb"),
                new AnyType(5, "dd"),
                new AnyType(7, "gg"),
                new AnyType(4, "dd")
        );
    }

    /**
     * 插入排序
     */
    @Test
    public void testInsertSort() {
        AnyType[] array = new AnyType[1];
        array = list.toArray(array);
        int len = array.length;
        int j;
        for (int i = 1; i < len; i++) {
            AnyType temp = array[i];
            for (j = i; j > 0 && temp.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j]=temp;
        }
        System.out.println(array);
    }
}
