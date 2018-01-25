package tx.test;

import codeTxTest.OrderDetailManagerImpl;
import codeTxTest.OrderMainManagerImpl;
import com.yanhuan.yhssm.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by yanhuan1 on 2018/1/25.
 */
public class CodeTxTest extends BaseTest {

    @Resource(name = "mainManager")
    private OrderMainManagerImpl orderMainManager;

    @Resource(name = "detailManager")
    private OrderDetailManagerImpl detailManager;

    @Test
    public void testCodeTx() throws Exception {
        int i = 0;
        orderMainManager.insertMain();
        detailManager.insertDetail();
    }
}
