package algorithm.bag.thinkCP;

import algorithm.bag.Detail;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import freemarker.ext.beans.HashAdapter;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by yanhuan1 on 2018/3/30.
 */
public class BagNewTest {

    private static final String STR = "man";

    @Test
    public void testBag() {
        List<Detail> detailList = Lists.newArrayList(
                new Detail(1l, "1", 1),
                new Detail(2l, "2", 2),
                new Detail(3l, "3", 3),
                new Detail(4l, "4", 4),
                new Detail(5l, "5", 5),
                new Detail(6l, "6", 6),
                new Detail(7l, "7", 7),
                new Detail(8l, "8", 8),
                new Detail(9l, "9", 9),
                new Detail(10l, "10", 10),
                new Detail(65l, "65", 65)
        );
        OptionalCombinationWithCp optionalCombinationWithCp = new OptionalCombinationWithCpImpl2();
        List<Detail> optional = optionalCombinationWithCp.findOptional(detailList, 35, 12);
        optional.stream().forEach(System.out::println);
    }

    @Test
    public void testBagMultiThread() throws Exception {
        Map<String, List<Detail>> map = new HashMap<>();
        Map<String, Future<List<Detail>>> fMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(STR + i, getDetailList(STR + i));
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        OptionalCombinationWithCp optionalCombinationWithCp = new OptionalCombinationWithCpImpl();
        Future<List<Detail>> future;
        for (int i = 0; i < 100; i++) {
            final String s = STR + i;
            future = executorService.submit((Callable<List<Detail>>) () -> optionalCombinationWithCp.findOptional(map.get(s), 2000, 450));
            fMap.put(s, future);
        }
        List<Detail> detailList = fMap.get(STR + 10).get();
        detailList.stream().forEach(System.out::println);
        System.out.println(getSum(detailList));

    }

    private List<Detail> getDetailList(String str) {
        List<Detail> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randInt = random.nextInt(1000) + 1;
            list.add(new Detail(Long.valueOf(randInt), str, randInt));
        }
        return list;
    }

    private Integer getSum(List<Detail> detailList) {
        Integer sum = 0;
        for (Detail detail : detailList) {
            sum += detail.getQty();
        }
        return sum;
    }




}
