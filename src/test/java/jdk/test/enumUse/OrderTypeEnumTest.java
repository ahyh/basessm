package jdk.test.enumUse;

import org.junit.Test;

/**
 * 枚举测试
 */
public class OrderTypeEnumTest {

    @Test
    public void testOrderTypeEnum() {
        for (OrderTypeEnum orderTypeEnum : OrderTypeEnum.values()) {
            System.out.println(orderTypeEnum + " description:" + orderTypeEnum.getDescription());
        }
    }
}
