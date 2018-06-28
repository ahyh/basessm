package codeTxTest;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.OrderDetailDao;
import com.yanhuan.yhssm.dao.OrderMainDao;
import com.yanhuan.yhssm.domain.bussiness.Store;
import com.yanhuan.yhssm.domain.pojo.OrderDetail;
import com.yanhuan.yhssm.domain.pojo.OrderMain;
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
@Component("mainManager")
public class OrderMainManagerImpl extends BaseManager {

    @Resource
    private OrderMainDao orderMainDao;

    @Resource
    private OrderDetailDao orderDetailDao;

    @Resource(name = "detailManager")
    private OrderDetailManagerImpl orderDetailManager;

    @Resource(name = "salaryManager")
    private SalaryManager salaryManager;

    public Integer insertMain() {
        TransactionTemplate template = this.getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    OrderMain orderMain = buildMain();
                    Integer insert = orderMainDao.insert(orderMain);
                    if (insert != 1) throw new RuntimeException("insert Main false");
                    Integer insertSalNum = salaryManager.insertSalary();
                    if (insertSalNum != 1) throw new RuntimeException("insert Salary false");
                    OrderMain updateOrderMain = new OrderMain();
                    updateOrderMain.setId(9l);
                    updateOrderMain.setBuyer("pppppppppppp");
                    updateOrderMain.setUpdateUser("hhhhhh");
                    updateOrderMain(updateOrderMain);

                    /**
                     * 此处测试在事务中进行的写操作，在未提交之前只能在此事务中查询到，其他事务查询不到
                     */
                    OrderMain orderMain1 = orderMainDao.get(orderMain.getId());

                    OrderDetail updateOrderDetail = new OrderDetail();
                    updateOrderDetail.setId(17l);
                    updateOrderDetail.setGoodsNo("abcdefg");
                    updateOrderDetail.setUpdateUser("fefeefe");
                    updateOrderDetail(updateOrderDetail);

//                    throw new RuntimeException("rollback");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            private OrderMain buildMain() {
                OrderMain orderMain = new OrderMain();
                Store store = new Store(1, "a", 2, "b", 3, "c");
                orderMain.setOrderNo("hhhhhh");
                orderMain.setOrderType((byte) 0);
                orderMain.setOrderStatus((byte) 0);
                orderMain.setPayStatus((byte) 0);
                orderMain.setSkuCount(5);
                orderMain.setGoodsCount(10);
                orderMain.setBuyer("aaaa");
                orderMain.setIsVip((byte) 1);
                orderMain.setSaleManNo("HF1002");
                orderMain.setSaleManName("HF1002");
                orderMain.setPayWayType((byte) 2);
                orderMain.setOrderAmount(new BigDecimal(1000));
                orderMain.setActualAmount(new BigDecimal(900));
                orderMain.setCreateTime(new Date());
                orderMain.setCreateUser("yanhuan");
                setOrderMainProp(orderMain, store);
                orderMain.setCreateUser("yanhuan");
                return orderMain;
            }

            private void setOrderMainProp(OrderMain orderMain, Store store) {
                orderMain.setProvinceNo(store.getProvinceNo());
                orderMain.setProvinceName(store.getProvinceName());
                orderMain.setCityNo(store.getCityNo());
                orderMain.setCityName(store.getCityName());
                orderMain.setStoreNo(store.getStoreNo());
                orderMain.setStoreName(store.getStoreName());
            }
        });
        return 0;
    }

    private void updateOrderMain(OrderMain orderMain) {
        Preconditions.checkNotNull(orderMain);
        orderMainDao.update(orderMain);
    }

    private void updateOrderDetail(OrderDetail orderDetail) {
        Preconditions.checkNotNull(orderDetail);
        orderDetailDao.update(orderDetail);
        throw new RuntimeException("throw a runtimeException,test code Tx!");
    }


}
