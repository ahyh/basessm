package guava.test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * guava四种新集合测试
 * Created by yanhuan1 on 2018/1/23.
 */
public class GuavaCollectionTest {

    private static List<Detail> detailList = Arrays.asList(
            new Detail("10001", "100010001"),
            new Detail("10001", "100010002"),
            new Detail("10001", "100010003"),
            new Detail("10001", "100010003"),
            new Detail("20002", "200020004"),
            new Detail("20002", "200020005"),
            new Detail("20002", "200020009"),
            new Detail("20002", "200020009"),
            new Detail("30003", "300030006"),
            new Detail("30003", "300030007"),
            new Detail("30003", "300030008"),
            new Detail("30003", "300030008")
    );

    @Test
    public void testNormal() {
        Map<String, Set<String>> orderNo2GoodsNoSetMap = new HashMap<>();
        Set<String> goodsNoSet;
        for (Detail detail : detailList) {
            if (!orderNo2GoodsNoSetMap.containsKey(detail.getOrderNo())) {
                goodsNoSet = new HashSet<>();
                goodsNoSet.add(detail.getGoodsNo());
                orderNo2GoodsNoSetMap.put(detail.getOrderNo(), goodsNoSet);
            } else {
                orderNo2GoodsNoSetMap.get(detail.getOrderNo()).add(detail.getGoodsNo());
            }
        }
        printMap(orderNo2GoodsNoSetMap);
    }

    @Test
    public void testGuavaCollection() {
        Multimap<String,String> multimap = HashMultimap.create();
        for (Detail detail:detailList){
            multimap.put(detail.getOrderNo(),detail.getGoodsNo());
        }
        Map<String, Collection<String>> map = multimap.asMap();
        for (Map.Entry<String,Collection<String>> entry:map.entrySet()){
            for (String s : entry.getValue()) {
                System.out.println(entry.getKey() + ":" + s);
            }
        }
    }

    @Test
    public void testStream(){
        Map<String, List<Detail>> collect = detailList.stream().collect(Collectors.groupingBy(Detail::getOrderNo));
        Map<String, Long> collect1 = detailList.stream().collect(Collectors.groupingBy(Detail::getOrderNo, Collectors.counting()));

    }

    private static void printMap(Map<String,Set<String>> map) {
        if (null != map && map.size() > 0) {
            for (Map.Entry<String,Set<String>> entry : map.entrySet()) {
                for (String s : entry.getValue()) {
                    System.out.println(entry.getKey() + ":" + s);
                }
            }
        }
    }


}

class Detail {

    private String orderNo;

    private String goodsNo;

    public Detail() {
    }

    public Detail(String orderNo, String goodsNo) {
        this.orderNo = orderNo;
        this.goodsNo = goodsNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "orderNo='" + orderNo + '\'' +
                ", goodsNo='" + goodsNo + '\'' +
                '}';
    }

}
