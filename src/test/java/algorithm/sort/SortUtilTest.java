package algorithm.sort;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.omg.CORBA.Any;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 排序工具测试
 */
public class SortUtilTest {

    private static List<AnyType> list = new ArrayList<>();

    private static final Integer SIZE = 1000000;

    static {
        Integer a;
        String str;
        for (int i = 0; i < SIZE; i++) {
            a = (int) (SIZE * Math.random());
            str = "pre" + a;
            list.add(new AnyType(a, str));
        }
    }

    /**
     * 插入排序测试
     */
    @Test
    public void testInsertSort() {
        long startTime = System.currentTimeMillis();
        List<AnyType> comparables = (List<AnyType>) SortUtil.insertSort(list);
        long useTime = System.currentTimeMillis() - startTime;
        System.out.println("InsertSort use time:" + useTime);
//        comparables.stream().forEach(System.out::println);
    }

    /**
     * 希尔排序测试
     */
    @Test
    public void testShellSort() {
        long startTime = System.currentTimeMillis();
        List<AnyType> comparables = (List<AnyType>) SortUtil.shellSort(list);
        long useTime = System.currentTimeMillis() - startTime;
        System.out.println("ShellSort use time:" + useTime);
//        comparables.stream().forEach(System.out::println);
    }

    /**
     * 堆排序测试
     */
    @Test
    public void testHeapSort() {
        long startTime = System.currentTimeMillis();
        List<AnyType> comparables = (List<AnyType>) SortUtil.heapSort(list);
        long useTime = System.currentTimeMillis() - startTime;
        System.out.println("HeapSort use time:" + useTime);
//        comparables.stream().forEach(System.out::println);
    }


    /**
     * 归并排序测试
     */
    @Test
    public void testMergeSort() {
        long startTime = System.currentTimeMillis();
        List<AnyType> comparables = (List<AnyType>) SortUtil.mergeSort(list);
        long useTime = System.currentTimeMillis() - startTime;
        System.out.println("HeapSort use time:" + useTime);
//        comparables.stream().forEach(System.out::println);
    }

    /**
     * 归并排序测试
     */
    @Test
    public void testQuickSort() {
        long startTime = System.currentTimeMillis();
        List<AnyType> comparables = (List<AnyType>) SortUtil.quickSort(list);
        long useTime = System.currentTimeMillis() - startTime;
        System.out.println("HeapSort use time:" + useTime);
//        comparables.stream().forEach(System.out::println);
    }
}
