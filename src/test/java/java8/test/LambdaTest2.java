package java8.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8内置了四大核心函数式接口
 * Consumer<T>:消费型接口
 * void accept(T t);
 * Supplier<T>:供给型接口
 * T get();
 * Function<T,R>:函数型接口
 * R apply(T t);
 * Predicate<T>:断言型接口
 * Boolean test(T t);
 * Created by yanhuan1 on 2018/1/25.
 */
public class LambdaTest2 {

    /**
     * 消费型接口测试
     */
    @Test
    public void testConsumer() {
        consumer("yanhuan", x -> System.out.println("HelloWorld" + x));
    }

    private void consumer(String arg, Consumer consumer) {
        consumer.accept(arg);
    }

    /**
     * 生产型接口测试
     */
    @Test
    public void testSupplier() {
        List<Integer> list = get(10, () -> (int) (Math.random() * 10));
        list.stream().forEach(System.out::println);
    }

    private List<Integer> get(Integer num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    /**
     * 函数型接口测试
     */
    @Test
    public void testFunction() {
        Set<String> set = Sets.newHashSet("aa", "bbb", "cccc");
        Map<String, Integer> fun = (Map) fun(set, x -> {
            Map<String, Integer> map = new HashMap<>();
            for (Object obj : set) {
                map.put((String) obj, ((String) obj).length());
            }
            return map;
        });
        for (Map.Entry<String, Integer> entry : fun.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private Object fun(Collection<String> collection, Function function) {
        return function.apply(collection);
    }

    /**
     * 断言型接口测试
     */
    @Test
    public void testPredicate() {
        List<String> list = Lists.newArrayList("aa","ab","bc","ac","cb","ca");
        List<String> newList = filter(list, x -> x.startsWith("a"));
        newList.stream().forEach(System.out::println);
    }

    private List<String> filter(List<String> list, Predicate<String> predicate) {
        List<String> newList = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                newList.add(str);
            }
        }
        return newList;
    }

}
