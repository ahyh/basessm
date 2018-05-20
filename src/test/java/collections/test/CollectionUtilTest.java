package collections.test;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class CollectionUtilTest {

    @Test
    public void test1() {
        Goods g1 = new Goods(1, "1001", "AA");
        Goods g2 = new Goods(2, "1002", "BB");
        Goods g3 = new Goods(3, "1003", "BB");
        Goods g4 = new Goods(4, "1004", "CC");
        Goods g5 = new Goods(5, "1005", "DD");
        Goods g6 = new Goods(6, "1006", "EE");
        Goods g7 = new Goods(7, "1007", "FF");
        Goods g8 = new Goods(1, "1001", "GG");
        Goods g9 = new Goods(2, "1002", "HH");
        Goods g0 = new Goods(3, "1003", "II");
        List<Goods> list1 = Lists.newArrayList(g1, g2, g3, g4, g5, g6);
        List<Goods> list2 = Lists.newArrayList(g5, g6, g7, g8, g9, g0);
//        Collection<Goods> disjunction = CollectionUtils.disjunction(list1, list2);
//        disjunction.stream().forEach(System.out::println);
        Collection<Goods> goods = CollectionUtils.intersection(list1, list2);
        goods.stream().forEach(System.out::println);
    }
}

class Goods {
    private Integer id;
    private String goodsNo;
    private String goodsName;

    public Goods() {
    }

    public Goods(Integer id, String goodsNo, String goodsName) {
        this.id = id;
        this.goodsNo = goodsNo;
        this.goodsName = goodsName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsNo='" + goodsNo + '\'' +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}
