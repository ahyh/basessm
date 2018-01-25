package codeTxTest;

import com.yanhuan.yhssm.dao.SalaryDao;
import com.yanhuan.yhssm.domain.pojo.Salary;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 测试编程式事务
 * Created by yanhuan1 on 2018/1/25.
 */
@Component("salaryManager")
public class SalaryManager extends BaseManager {

    @Resource
    private SalaryDao salaryDao;

    public Integer insertSalary() {
        TransactionTemplate template = this.getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    Salary salary = buildSalary();
                    Integer insert = salaryDao.insert(salary);
                    if (insert != 1) throw new RuntimeException("insert salary false");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            private Salary buildSalary(){
                Salary salary = new Salary();
                salary.setName("陈昔");
                salary.setAge(18);
                salary.setSex((byte) 1);
                salary.setCompany("京东物流");
                salary.setSalary(new BigDecimal(22222));
                salary.setCreateTime(new Date());
                salary.setUpdateTime(new Date());
                salary.setCreateUser("yanhuan");
                salary.setUpdateUser("yanhuan");
                return salary;
            }
        });
        return 1;
    }
}
