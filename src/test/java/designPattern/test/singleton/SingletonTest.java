package designPattern.test.singleton;

import org.junit.Assert;
import org.junit.Test;

/**
 * 单例测试方法
 * Created by yanhuan1 on 2018/1/28.
 */
public class SingletonTest {

    @Test
    public void testSingleton1(){
        Singleton1 singleton1 = Singleton1.getSingleton();
        Singleton1 singleton2 = Singleton1.getSingleton();
        //断言两者是同一对象
        Assert.assertTrue(singleton1 == singleton2);
    }

    @Test
    public void testSingleton2(){
        Singleton2 singleton1 = Singleton2.getSingleton();
        Singleton2 singleton2 = Singleton2.getSingleton();
        //断言两者是同一对象
        Assert.assertTrue(singleton1 == singleton2);
    }

    @Test
    public void testSingleton3(){
        Singleton3 singleton1 = Singleton3.getSingleton();
        Singleton3 singleton2 = Singleton3.getSingleton();
        //断言两者是同一对象
        Assert.assertTrue(singleton1 == singleton2);
    }

    @Test
    public void testSingleton4(){
        Singleton4 singleton1 = Singleton4.getSingleton();
        Singleton4 singleton2 = Singleton4.getSingleton();
        //断言两者是同一对象
        Assert.assertTrue(singleton1 == singleton2);
    }

    @Test
    public void testSingleton5(){
        Singleton5 singleton1 = Singleton5.INSTANCE;
        Singleton5 singleton2 = Singleton5.INSTANCE;
        //断言两者是同一对象
        Assert.assertTrue(singleton1 == singleton2);
    }


}
