package com.yh.lang3.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testIsNotEmpty() {
        String s = "";
        String ss = " ";
        System.out.println(StringUtils.isEmpty(s));    //true
        System.out.println(StringUtils.isEmpty(ss));   //false
    }

    @Test
    public void testIsNotBlank() {
        String s = "";
        String ss = " ";
        System.out.println(StringUtils.isBlank(s));    //true
        System.out.println(StringUtils.isBlank(ss));   //true
    }

    @Test
    public void testDoubleConvertInteger(){
        Double qty = new Double(50.0);
        System.out.println(qty.intValue());
    }
}
