package utils.test;

import com.google.common.collect.Lists;
import com.yanhuan.yhssm.domain.condition.OrderDetailCondition;
import com.yanhuan.yhssm.domain.condition.OrderMainCondition;
import com.yanhuan.yhssm.utils.BeanCopyUtil;
import org.junit.Test;

import java.util.List;

public class BeanCopyUtilTest {

    @Test
    public void testBeanCopy(){
        OrderMainCondition mainCondition = new OrderMainCondition();
        mainCondition.setOrderNo("12345678");
        mainCondition.setProvinceNo(34);
        mainCondition.setProvinceName("安徽省");
        OrderDetailCondition copy = BeanCopyUtil.copy(mainCondition, OrderDetailCondition.class);
        System.out.println(copy);
    }

    @Test
    public void testBeanCopyList(){
        OrderMainCondition mainCondition = new OrderMainCondition();
        mainCondition.setOrderNo("342401");
        mainCondition.setProvinceNo(34);
        mainCondition.setProvinceName("安徽省");

        OrderMainCondition mainCondition1 = new OrderMainCondition();
        mainCondition1.setOrderNo("422401");
        mainCondition1.setCityNo(42);
        mainCondition1.setProvinceName("湖北省");

        List<OrderMainCondition> list = Lists.newArrayList(mainCondition,mainCondition1);
        List<OrderDetailCondition> copy = BeanCopyUtil.copy(list, OrderDetailCondition.class);
        copy.stream().forEach(System.out::println);
    }
}
