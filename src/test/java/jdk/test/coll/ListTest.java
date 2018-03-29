package jdk.test.coll;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * 集合List测试
 */
public class ListTest {

    /**
     * List.contains方法测试
     */
    @Test
    public void testListContains() {
        List<String> strList = Lists.newArrayList("aa", "cc", "ee", "bb");
        List<String> strList2 = Lists.newArrayList("bb", "ff", "cc", "pp");
        for (String str : strList) {
            if (strList2.contains(str)) {
                System.out.print("strList2 contains [" + str + "]");
            }
        }
    }
}
