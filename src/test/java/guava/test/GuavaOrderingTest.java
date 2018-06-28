package guava.test;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 排序器测试
 */
public class GuavaOrderingTest {

    @Test
    public void testOrdering() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        OrderBean orderBean1 = new OrderBean(1l, "1001", sdf.parse("2018-03-01 12:12:12"), sdf.parse("2018-03-03 14:14:14"), 3, new BigDecimal("200.00"));
        OrderBean orderBean2 = new OrderBean(2l, "1002", sdf.parse("2018-03-02 12:12:12"), null, 4, new BigDecimal("300.00"));
        OrderBean orderBean3 = new OrderBean(3l, "1003", sdf.parse("2018-03-06 12:12:12"), sdf.parse("2018-03-07 14:14:14"), 2, new BigDecimal("100.00"));
        OrderBean orderBean4 = new OrderBean(4l, "1004", sdf.parse("2018-03-04 12:12:12"), null, 5, null);
        OrderBean orderBean5 = new OrderBean(5l, "1005", sdf.parse("2018-03-03 12:12:12"), null, 6, new BigDecimal("200.00"));
        OrderBean orderBean6 = new OrderBean(6l, "1006", sdf.parse("2018-03-02 12:12:12"), sdf.parse("2018-03-04 14:14:14"), 1, new BigDecimal("100.00"));
        OrderBean orderBean7 = new OrderBean(4l, "1004", sdf.parse("2018-03-01 12:12:12"), sdf.parse("2018-03-09 14:14:14"), 5, null);
        OrderBean orderBean8 = new OrderBean(4l, "1004", sdf.parse("2018-03-02 12:12:12"), sdf.parse("2018-03-05 14:14:14"), 7, null);
        OrderBean orderBean9 = new OrderBean(4l, "1004", sdf.parse("2018-03-03 12:12:12"), sdf.parse("2018-03-04 14:14:14"), 6, null);

        List<OrderBean> orderBeanList = Lists.newArrayList(orderBean1, orderBean2, orderBean3, orderBean4, orderBean5, orderBean6, orderBean7, orderBean8, orderBean9);

        Ordering<OrderBean> ordering = Ordering.natural().nullsLast().onResultOf((Function<OrderBean, Comparable>) orderBean -> orderBean.getFinishTime()).compound((o1, o2) -> {
            if (o1.getAmount() != null && o2.getAmount() != null) {
                return o1.getAmount().compareTo(o2.getAmount());
            } else {
                return o1.getCreateTime().compareTo(o2.getCreateTime());
            }
        });

        List<OrderBean> orderBeanList1 = ordering.sortedCopy(orderBeanList);
        orderBeanList1.stream().forEach(System.out::println);
        System.out.println("==================================================");
        List<OrderBean> orderBeanList2 = ordering.leastOf(orderBeanList, 4);
        orderBeanList2.stream().forEach(System.out::println);
    }

    @Test
    public void testMap2JSON(){
        Map<String,String> map = new HashMap<>();
        map.put("orgNo","6");
        map.put("distributeNo","6");
        map.put("warehouseNo","80");
        map.put("containerNo","000200098209999");
        String s = JSON.toJSONString(map);
        System.out.println(s);
    }
}
