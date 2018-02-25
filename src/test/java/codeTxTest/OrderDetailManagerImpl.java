package codeTxTest;

import com.yanhuan.yhssm.dao.OrderDetailDao;
import com.yanhuan.yhssm.domain.bussiness.Goods;
import com.yanhuan.yhssm.domain.pojo.OrderDetail;
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
@Component("detailManager")
public class OrderDetailManagerImpl extends BaseManager {

    @Resource
    private OrderDetailDao orderDetailDao;

    public void insertDetail() throws Exception {
        TransactionTemplate template = this.getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                OrderDetail detail = new OrderDetail();
                Goods goods = new Goods((byte) 0, "100001", "华为mate10", 1, "电子", 11, "通讯", 111, "手机", "华为", "金色", new BigDecimal("4999.00"));
                detail = buildDetail(detail, goods);
                Integer insert = orderDetailDao.insert(detail);
                if (insert != 1) throw new RuntimeException("insert detail false");
            }

            private OrderDetail buildDetail(OrderDetail detail, Goods goods) {
                detail.setGoodsType(goods.getGoodsType());
                detail.setGoodsNo(goods.getGoodsNo());
                detail.setGoodsName(goods.getGoodsName());
                detail.setBarcode(goods.getGoodsNo());
                detail.setBrand(goods.getBrand());
                detail.setColor(goods.getColor());
                detail.setPrice(goods.getPrice());
                detail.setDiscount(new BigDecimal(0.9));
                detail.setFirstCateNo(goods.getFirstCateNo());
                detail.setFirstCateName(goods.getFirstCateName());
                detail.setSecondCateNo(goods.getSecondCateNo());
                detail.setSecondCateName(goods.getSecondCateName());
                detail.setThirdCateNo(goods.getThirdCateNo());
                detail.setThirdCateName(goods.getThirdCateName());
                detail.setOrderNo("ynyhyhyh");
                detail.setProvinceNo(1);
                detail.setProvinceName("a");
                detail.setCityNo(2);
                detail.setCityName("b");
                detail.setStoreNo(3);
                detail.setStoreName("c");
                detail.setQty(2);
                detail.setCreateTime(new Date());
                detail.setCreateUser("yhyh");
                return detail;
            }
        });
    }

}

