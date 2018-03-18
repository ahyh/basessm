package jdk.test.ref;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.ref.*;
import java.util.*;

/**
 * 引用测试类
 */
public class References {

    //PlantomReference必须放在这个Queue里面了
    private static ReferenceQueue<VeryLarge> referenceQueue = new ReferenceQueue<>();

    public static void checkQueue() {
        Reference<? extends VeryLarge> inq = referenceQueue.poll();
        if (inq != null) {
            System.out.println("In queue" + inq.get());
        }
    }

    @Test
    public void testNew(){
        //通过引用链获取到对象，程序运行过程任意一个环节不会为null
        List<Integer> intList = new ArrayList<>();
        intList.add(new Integer("2"));
        Map<String,List<Integer>> map = new HashMap<>();
        map.put("aa",intList);
        System.out.println(map.get("aa").get(0));
    }

    public static void main(String[] args) {
        int size = 10;
        List<Integer> intList = Lists.newArrayList(1,2,3,5,6);
        LinkedList<SoftReference<VeryLarge>> softReferenceList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            softReferenceList.add(new SoftReference<VeryLarge>(new VeryLarge("Soft" + i,intList), referenceQueue));
            System.out.println("Soft created:" + softReferenceList.getLast());
            checkQueue();
        }

        LinkedList<WeakReference<VeryLarge>> weakReferenceList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            weakReferenceList.add(new WeakReference<VeryLarge>(new VeryLarge("Weak" + i,intList), referenceQueue));
            System.out.println("Weak created:" + weakReferenceList.getLast());
            checkQueue();
        }

        SoftReference<VeryLarge> soft = new SoftReference<>(new VeryLarge("Soft",intList));
        WeakReference<VeryLarge> weak = new WeakReference<>(new VeryLarge("Weak",intList));
        System.gc();

        LinkedList<PhantomReference<VeryLarge>> phantomReferences = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            phantomReferences.add(new PhantomReference<>(new VeryLarge("Phantom" + i,intList), referenceQueue));
            System.out.println("Just created:" + phantomReferences.getLast());
            checkQueue();
        }
    }


    @Test
    public void testStrong(){
        //新建一个对象
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        //创建一个强引用
        VeryLarge veryLarge = new VeryLarge("Soft", intList);
        System.gc();
        //false，gc不会回收强引用的对象
        System.out.println(null == veryLarge);
        while(true){
            int[] ints = new int[1000000000];
            VeryLarge veryLarge1 = new VeryLarge("Soft", ints);
        }
    }

    @Test
    public void testSoft() {
//        //新建一个对象
//        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1);
//        //创建一个软引用
//        SoftReference<VeryLarge> softReference = new SoftReference<VeryLarge>(new VeryLarge("Soft", intList));
//        System.gc();
//        VeryLarge veryLarge = softReference.get();
//        //不为null，对象还在
//        System.out.println(veryLarge);

        //创建一个软引用，包含一个对象
        SoftReference<Integer> soft = new SoftReference<>(new Integer("23456"));
        //提醒系统进行一个垃圾收集
        System.gc();
        System.out.println(soft.get() == null);

        //创建一个弱引用，包含一个对象
        WeakReference<Integer> weak = new WeakReference<>(new Integer("23456"));
        System.gc();
        System.out.println(weak.get() == null);

        //创建一个虚引用，包含一个对象
        ReferenceQueue<Integer> intRq = new ReferenceQueue<>();
        PhantomReference<Integer> phantom = new PhantomReference<>(new Integer("23456"),intRq);
        //弱引用包含的对象可以通过get()获取到
        Integer phantomNum = phantom.get();
        System.out.println(phantomNum == null);
    }

    @Test
    public void testWeak() {
        List<Integer> intList = Lists.newArrayList(1, 2, 4);
        //创建一个弱引用
        WeakReference<VeryLarge> weakReference = new WeakReference<VeryLarge>(new VeryLarge("Soft", intList));
        System.gc();
        VeryLarge veryLarge = weakReference.get();
        //为null，垃圾收集器一工作就回收
        System.out.println(veryLarge);
    }

    @Test
    public void testPhantom() {
        List<Integer> intList = Lists.newArrayList(1, 2, 4);
        //创建一个幽灵引用，幽灵引用必须放在ReferenceQueue中
        ReferenceQueue<VeryLarge> referenceQueue = new ReferenceQueue<>();
        PhantomReference<VeryLarge> weakReference = new PhantomReference<VeryLarge>(new VeryLarge("Soft", intList), referenceQueue);
        VeryLarge veryLarge = weakReference.get();
        //为null，幽灵
        System.out.println(veryLarge);
    }
}
