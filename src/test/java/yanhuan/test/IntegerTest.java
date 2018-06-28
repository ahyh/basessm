package yanhuan.test;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 整数测试
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        System.out.println(a == b);   //false

        Integer aa = 100;
        Integer bb = 100;
        System.out.println(aa == bb);  //true

        Integer aa1 = 127;
        Integer bb1 = 127;
        System.out.println(aa1 == bb1);  //true

        Integer aa2 = 128;
        Integer bb2 = 128;
        System.out.println(aa2 == bb2);  //false

        Integer aaa = 200000;
        Integer bbb = 200000;
        System.out.println(aaa == bbb); //false
    }

    @Test
    public void testLinkedMap(){
        Map<String,Object> map = new LinkedHashMap<>();
    }
}
