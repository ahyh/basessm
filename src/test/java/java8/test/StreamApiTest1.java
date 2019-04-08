package java8.test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 流式编程测试
 * Created by yanhuan1 on 2018/1/25.
 */
public class StreamApiTest1 {

    Person person1 = new Person(1l, 22, "aa", 1111.11, true, (byte) 1);
    Person person2 = new Person(2l, 23, "bb", 2222.11, false, (byte) 2);
    Person person3 = new Person(3l, 24, "cc", 3333.11, true, (byte) 3);
    Person person4 = new Person(4l, 25, "dd", 4444.11, false, (byte) 1);
    Person person5 = new Person(5l, 26, "aa", 5555.11, true, (byte) 2);
    Person person6 = new Person(6l, 27, "bb", 6666.11, false, (byte) 2);
    Person person7 = new Person(7l, 28, "cc", 7777.11, true, (byte) 1);
    Person person8 = new Person(8l, 29, "dd", 8888.11, false, (byte) 2);
    Person person9 = new Person(9l, 30, "aa", 9999.11, true, (byte) 3);
    Person person10 = new Person(10l, 31, "bb", 10000.11, false, (byte) 1);
    Person person11 = new Person(11l, 31, "cc", 10000.11, false, (byte) 1);
    Person person12 = new Person(12l, 31, "dd", 10000.11, false, (byte) 1);
    List<Person> list = Lists.newArrayList(person1, person2, person3, person4, person5, person6, person7, person8, person9, person10, person11, person12);


    @Test
    public void testGetIdMap() {
        list.stream().filter(x -> x.getSalary() > 6666.6).forEach(System.out::println);
    }

    /**
     * filter过滤，过滤出符合条件的集合
     */
    @Test
    public void testFilter() {
        list.stream().filter(x -> x.getStatus() == (byte) 1).forEach(System.out::println);
        List<Person> collect = list.stream().filter(x -> x.getStatus() == (byte) 1).filter(x -> x.getSalary() > 6000d).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    /**
     * distinct滤重，基于equals方法实现
     */
    @Test
    public void testDistinct() {
        list.stream().map(x -> x.getName()).distinct().forEach(System.out::println);
    }

    /**
     * limit截断操作，取前n个元素
     */
    @Test
    public void testLimit() {
        list.stream().filter(x -> x.getSalary() > 6000).limit(2).forEach(System.out::println);
    }

    /**
     * sorted排序操作
     */
    @Test
    public void testSorted() {
        list.stream().sorted(Comparator.comparingDouble(Person::getSalary)).limit(5).forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        float a = 1.2f;
        int b = (int)a;
        System.out.println(b);

    }

    @Test
    public void testMap() {
        Map<Long, String> map = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
        System.out.println();
    }


}

