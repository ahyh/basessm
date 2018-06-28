package utils.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void test(){
        String s = "  ";
        boolean noneEmpty = StringUtils.isNoneBlank(s);
        boolean empty = StringUtils.isNotBlank(s);
        System.out.println(noneEmpty);
    }
}
