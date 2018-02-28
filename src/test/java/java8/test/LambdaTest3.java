package java8.test;

import com.yanhuan.yhssm.domain.bussiness.Goods;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用：如果Lambda体中的内容有方法已经实现了，可以使用“方法引用”
 * Lambda表达式的另外一种形式
 * 主要有三种语法格式：
 * 对象::实例方法名，要求实现的方法的入参和返回值类型和方法引用的入参和返回值的类型保持一致
 * 类::静态方法名
 * 类::实例方法名
 * Created by yanhuan1 on 2018/1/25.
 */
public class LambdaTest3 {

    /**
     * 对象::实例方法名
     */
    @Test
    public void test1(){
        Consumer<String> con = System.out::println;
        con.accept("yanhuan");
    }

    /**
     * 类::静态方法名的方式
     * 要求函数式接口的入参、返回值类型与静态方法的入参、返回值类型保持一致
     */
    @Test
    public void test2(){
        Comparator<Integer> com = (x, y)->Integer.compare(x,y);
        Comparator<Integer> com2 = Integer::compare;
        TreeSet<Integer> treeSet = new TreeSet<>(com2);
        for (int i = 0; i < 10; i++) {
            treeSet.add((int) (Math.random() * 100));
        }
        treeSet.stream().forEach(System.out::println);
    }

    /**
     * 类::实例方法名方式
     * 要求函数式接口的第一个参数是实例方法的调用者，第二个参数是实例方法的入参时可以使用
     */
    @Test
    public void test3(){
        BiPredicate<String,String> predicate = (x, y)->x.equals(y);
        BiPredicate<String,String> biPredicate = String::equals;
        boolean flag = comStr("yanhuan","yanhuan",predicate);
        System.out.println(flag);
    }

    public boolean comStr(String s1,String s2,BiPredicate<String,String> predicate){
        return predicate.test(s1,s2);
    }

    /**
     * 构造器引用
     * 自动匹配无参构造器
     */
    @Test
    public void test4(){
        Supplier<Goods> supplier = Goods::new;
        Goods goods = supplier.get();
        System.out.println(goods);
    }

    @Test
    public void test5(){
        Function<String,Goods> function = Goods::new;
        Goods goods = function.apply("yanhuan");
        System.out.println(goods);
    }



}
