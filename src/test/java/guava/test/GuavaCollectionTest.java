package guava.test;

import com.google.common.base.Function;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.*;

/**
 * guava四种新集合测试
 */
public class GuavaCollectionTest {

    private static List<Detail> detailList = Arrays.asList(
            new Detail("10001", "100010001", 1),
            new Detail("10001", "100010002", 2),
            new Detail("10001", "100010003", 3),
            new Detail("10001", "100010003", 4),
            new Detail("20002", "200020004", 5),
            new Detail("20002", "200020005", 6),
            new Detail("20002", "200020009", 7),
            new Detail("20002", "200020009", 8),
            new Detail("30003", "300030006", 9),
            new Detail("30003", "300030007", 1),
            new Detail("30003", "300030008", 2),
            new Detail("30003", "300030008", 3)
    );

    /**
     * 找出orderNo对应的单子下的所有的goodsNo组合成一个Map<key:orderNo,value:goodsNoSet>
     * 传统的方法：
     * 1-确定orderNo2GoodsNoSetMap是否包含orderNo的key
     * 2-如果包含，则根据orderNo取出orderNo2GoodsNoSetMap对应的value,add进goodsNo
     * 3-如果不包含则new一个goodsNoSet，把goodsNo放入goodsNoSet中，在把Set集合放入Map中
     */
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

    /**
     * 找出orderNo对应的单子下的所有的goodsNo
     * 使用Guava集合的方式，直接放入Multimap对象中，最后使用asMap方法取出
     */
    @Test
    public void testGuavaCollection() {
        Multimap<String, Detail> multimap = HashMultimap.create();
        for (Detail detail : detailList) {
            multimap.put(detail.getOrderNo(), detail);
        }
        Map<String, Collection<Detail>> map = multimap.asMap();
        for (Map.Entry<String, Collection<Detail>> entry : map.entrySet()) {
            entry.getValue().stream().forEach(System.out::println);
        }
    }

    /**
     * JDK中的HashMap是key到value的映射，实际业务中有时候即需要从key-value的映射
     * 也需要value-key的映射，BiMap就可以实现这样的功能
     * 需要注意的是BiMap的key是一个Set集合，value也是一个Set集合
     */
    @Test
    public void testBiMap() {
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("aa", 1);
        biMap.put("bb", 2);
        biMap.put("cc", 3);
        for (BiMap.Entry<String, Integer> entry : biMap.entrySet()) {
            System.out.println("Key:" + entry.getKey() + ";" + "Value:" + entry.getValue());
        }
        //反转key-value的映射关系
        BiMap<Integer, String> inverseMap = biMap.inverse();
        for (BiMap.Entry<Integer, String> entry : inverseMap.entrySet()) {
            System.out.println("Key:" + entry.getKey() + ";" + "Value:" + entry.getValue());
        }
        //可以向inverseMap添加Entry
        inverseMap.put(4, "dd");
        //在吧inverseMap反转回去
        biMap = inverseMap.inverse();
        for (BiMap.Entry<String, Integer> entry : biMap.entrySet()) {
            System.out.println("Key:" + entry.getKey() + ";" + "Value:" + entry.getValue());
        }
    }

    /**
     * 统计相同元素在集合中出现的次数
     */
    @Test
    public void testMultiSet() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("aa");
        multiset.add("aa");
        multiset.add("aa");
        multiset.add("aa");
        multiset.add("bb");
        //一次性添加多个元素
        multiset.add("cc", 6);
        //统计"aa"出现的次数
        int aa = multiset.count("aa");
        System.out.println("count(aa):" + aa);
        System.out.println("count(cc):" + multiset.count("cc"));
        //multiset转换成Set集合
        Set<String> strSet = multiset.elementSet();
        strSet.stream().forEach(System.out::println);
        //统计每个词出现的次数
        Set<Multiset.Entry<String>> entrieSet = multiset.entrySet();
        for (Multiset.Entry<String> entry : entrieSet) {
            System.out.println("Str:" + entry.getElement() + ";Count:" + entry.getCount());
        }
    }

    /**
     * 需要获取orderNo+goodsNo到对应qty的映射Map，
     * 下面是传统方法获取
     */
    @Test
    public void testNormal3() {
        Map<String, Integer> orderNoGoodsNo2QtyMap = new HashMap<>();
        for (Detail detail : detailList) {
            orderNoGoodsNo2QtyMap.put(detail.getOrderNo() + "_" + detail.getGoodsNo(), detail.getQty());
        }
        for (Map.Entry<String, Integer> entry : orderNoGoodsNo2QtyMap.entrySet()) {
            String orderNoGoodsNo = entry.getKey();
            String orderNo = orderNoGoodsNo.split("_")[0];
            String goodsNo = orderNoGoodsNo.split("_")[1];
            System.out.println("orderNo:" + orderNo + ";goodsNo:" + goodsNo + ";qty:" + entry.getValue());
        }
    }

    /**
     * 传统的Map是一个key到一个value的映射，但是实际业务中经常需要多个key对应一个value
     * 使用guava新集合的方法,不需要使用一个中间切割符进行切割，代码结构更加清晰易懂
     */
    @Test
    public void testTable() {
        Table<String, String, Integer> table = HashBasedTable.create();
        for (Detail detail : detailList) {
            table.put(detail.getOrderNo(), detail.getGoodsNo(), detail.getQty());
        }
        for (Table.Cell<String, String, Integer> cell : table.cellSet()) {
            System.out.println("orderNo:" + cell.getColumnKey() + ";goodsNo:" + cell.getRowKey() + ";qty:" + cell.getValue());
        }
    }

    private static void printMap(Map<String, Set<String>> map) {
        if (null != map && map.size() > 0) {
            for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                for (String s : entry.getValue()) {
                    System.out.println(entry.getKey() + ":" + s);
                }
            }
        }
    }

    @Test
    public void testNullable(){
        List<String> strList = Lists.transform(detailList, new Function<Detail, String>() {
            @Override
            public String apply(Detail detail) {
                return null;
            }
        });
    }

}

class Detail {

    private String orderNo;

    private String goodsNo;

    private Integer qty;

    public Detail() {
    }

    public Detail(String orderNo, String goodsNo, Integer qty) {
        this.orderNo = orderNo;
        this.goodsNo = goodsNo;
        this.qty = qty;
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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "orderNo='" + orderNo + '\'' +
                ", goodsNo='" + goodsNo + '\'' +
                ", qty=" + qty +
                '}';
    }
}
