package utils.test;

import com.yanhuan.yhssm.utils.MoneyUtil;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * MoneyUtil测试类
 * Created by yanhuan1 on 2018/1/20.
 */
public class MoneyUtilTest {

    @Test
    public void testMoneyUtil(){
        BigDecimal money = new BigDecimal("111001.67");
        String s = MoneyUtil.number2Chinese(money);
        System.out.println(s);
    }

}
