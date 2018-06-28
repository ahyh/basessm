package java8.test;

import org.junit.Test;

/**
 * Created by yanhuan1 on 2018/3/2.
 */
public class IntegerTest1 {

    @Test
    public void testInteger(){
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        System.out.println(a == b);   //false
    }
}
