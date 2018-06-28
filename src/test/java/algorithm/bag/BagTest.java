package algorithm.bag;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by yanhuan1 on 2018/3/30.
 */
public class BagTest {

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
        OptionalCombination<Detail> optionalCombination = new OptionalStrategy();
        List<Detail> optional = optionalCombination.getOptional(detailList, 60);
        optional.stream().forEach(System.out::println);
    }
}
