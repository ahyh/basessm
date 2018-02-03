package utils.test;

import com.yanhuan.yhssm.domain.bussiness.Goods;
import com.yanhuan.yhssm.domain.bussiness.Store;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * 生成测试数据用的工具类
 * Created by yanhuan1 on 2018/1/20.
 */
public class GenerateUtils {

    private static List<String> firstNameList = Arrays.asList("赵", "钱", "孙", "李", "周", "吴", "郑", "王", "张", "严", "朱", "唐", "许", "余", "孔", "包");

    private static List<String> secondNameList = Arrays.asList("伟", "辉", "威", "亮", "安", "乔", "峰", "仁", "志", "慧", "子轩", "紫萱", "梓轩", "勇", "超", "静", "静静");

    private static List<Goods> goodsList = Arrays.asList(
            new Goods((byte) 0, "100001", "华为mate10", 1, "电子", 11, "通讯", 111, "手机", "华为", "金色", new BigDecimal("4999.00")),
            new Goods((byte) 0, "100002", "三星S8", 1, "电子", 11, "通讯", 111, "手机", "三星", "银色", new BigDecimal("6999.00")),
            new Goods((byte) 0, "100003", "小米Mix", 1, "电子", 11, "通讯", 111, "手机", "小米", "白色", new BigDecimal("1999.00")),
            new Goods((byte) 0, "100004", "苹果X", 1, "电子", 11, "通讯", 111, "手机", "Apple", "金色", new BigDecimal("9999.00")),
            new Goods((byte) 0, "100005", "魅族4Plus", 1, "电子", 11, "通讯", 111, "手机", "魅族", "蓝色", new BigDecimal("2111.00")),
            new Goods((byte) 0, "100006", "锤子T3", 1, "电子", 11, "通讯", 111, "手机", "锤子", "黑色", new BigDecimal("1566.00")),
            new Goods((byte) 0, "100007", "中兴SS", 1, "电子", 11, "通讯", 111, "手机", "中兴", "亮色", new BigDecimal("3588.00")),
            new Goods((byte) 1, "200001", "水浒传", 2, "图书", 21, "名著", 211, "古典小说", null, null, new BigDecimal("55.00")),
            new Goods((byte) 1, "200002", "西游记", 2, "图书", 21, "名著", 211, "古典小说", null, null, new BigDecimal("66.00")),
            new Goods((byte) 1, "200003", "三国演义", 2, "图书", 21, "名著", 211, "古典小说", null, null, new BigDecimal("53.00")),
            new Goods((byte) 1, "200003", "红楼梦", 2, "图书", 21, "名著", 211, "古典小说", null, null, new BigDecimal("77.00"))
    );

    private static List<Store> storeList = Arrays.asList(
            new Store(11, "北京", 1111, "东城区", 1111001, "北京东城图书城店"),
            new Store(11, "北京", 1112, "西城区", 1112003, "北京西城娱乐城店"),
            new Store(12, "河北", 1201, "石家庄", 1201001, "河北是家中中心城店"),
            new Store(34, "安徽", 3401, "合肥", 340110001, "安徽合肥万达中心城店"),
            new Store(34, "安徽", 3424, "六安", 340110001, "安徽六安城北城店")
    );

    public static String getNameRandom() {
        return firstNameList.get((int) (Math.random() * (firstNameList.size()))) + secondNameList.get((int) (Math.random() * (secondNameList.size())));
    }

    public static Byte getByteRandom(byte orgin) {
        return (byte) (Math.random() * orgin);
    }

    public static String getBizNo() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static Goods getGoodsRandom() {
        return goodsList.get((int) (Math.random() * goodsList.size()));
    }

    public static Store getStoreRandom() {
        return storeList.get((int) (Math.random() * storeList.size()));
    }

    public static List<Goods> getGoodsListRandom(int num) {
        if (num > goodsList.size()) {
            throw new RuntimeException("输入的数量太大了");
        }
        if (num == goodsList.size() - 1) {
            return goodsList;
        }
        List<Goods> newList = new ArrayList<>();
        Set<Integer> set = getRandomInts(goodsList.size(), num);
        for (Integer i : set) {
            newList.add(goodsList.get(i));
        }
        return newList;
    }

    public static Set<Integer> getRandomInts(int balance, int num) {
        Set<Integer> set = new HashSet<>();
        Integer tempInt;
        while (set.size() < num) {
            tempInt = (int) (Math.random() * balance);
            set.add(tempInt);
        }
        return set;
    }


    @Test
    public void testGetname() {
        String nameRandom = getNameRandom();
        System.out.println(nameRandom);
    }

    @Test
    public void testGetBizNo() {
        System.out.println(getBizNo());
    }

    @Test
    public void testGetByte() {
        System.out.println(getByteRandom((byte) 2));
    }

    @Test
    public void testGetGoodsList() {
        List<Goods> goodsListRandom = getGoodsListRandom(5);
        goodsListRandom.stream().forEach(System.out::println);
    }

}
