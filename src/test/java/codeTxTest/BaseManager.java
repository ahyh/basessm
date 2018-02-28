package codeTxTest;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * 测试编程式事务的传播行为
 * Created by yanhuan1 on 2018/1/25.
 */
public class BaseManager {

    @Resource(name="transactionManager")
    private PlatformTransactionManager transactionManager;

    public BaseManager() {
    }

    public TransactionTemplate getDataSourceTransactionManager() {
        return new TransactionTemplate(this.transactionManager);
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
