package java8.test;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Lambda表达式测试
 * * 1.Lambda表达式基础语法：Java8中引入了一个新的操作符“->”称为箭头操作符或Lambda操作符
 * “->”将Lambda表达式分为两部分：
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式所需执行的功能，Lambda体
 * <p>
 * 2.语法格式
 * 2.1无参数，无返回值，（）->
 * 2.2有一个参数，无返回值，（x）->,小括号可以省略不写
 * 2.3有两个参数，有返回值，如果有多条语句必须使用{}，
 * 2.4有多个参数，如果只有一条语句，{}和return都可以省略不写
 * 2.5Lambda表达式的参数列表的数据类型可以不写
 * <p>
 * 2.Lambda表达式需要函数式接口的支持
 * 函数式接口：接口中只有一个抽象方法，称为函数式接口，可以使用@FunctionInterface修饰
 * Created by yanhuan1 on 2018/1/25.
 */
public class LambdaTest1 {

    @Test
    public void testRunnable() {
        Runnable r1 = () -> System.out.println("LambdaTest");
        r1.run();
    }

    /**
     * 匿名内部类方式
     */
    @Test
    public void testNormal() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(com);
        addAndPrint(treeSet);
    }

    /**
     * Lambda表达式实现
     */
    @Test
    public void testLambda() {
        TreeSet<Integer> treeSet = new TreeSet<>((x, y) -> x - y);
        addAndPrint(treeSet);
    }

    private void addAndPrint(Set<Integer> set) {
        for (int i = 0; i < 10; i++) {
            set.add((int) (Math.random() * 100));
        }
        set.stream().forEach(System.out::println);
    }

    @Test
    public void testInteger(){
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        System.out.println(a == b);   //false
    }

}
