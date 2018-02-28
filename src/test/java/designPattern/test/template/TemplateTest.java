package designPattern.test.template;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import designPattern.test.template.opertates.BJOperate;
import designPattern.test.template.opertates.SHOperate;
import designPattern.test.template.pojo.OrderDetail;
import designPattern.test.template.pojo.OrderMain;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 模板模式测试
 */
public class TemplateTest {

    /**
     * 测试北京
     */
    @Test
    public void testBJOperate() {
        AbstractOperate operate = new BJOperate();
        operate.operate4(testJson());
    }

    /**
     * 测试上海
     */
    @Test
    public void testSHOperate() {
        AbstractOperate operate = new SHOperate();
        operate.operate4(testJson());
    }


    private String testJson() {
        OrderMain orderMain = new OrderMain();
        orderMain.setId(1l);
        orderMain.setOrderNo("12345678");
        orderMain.setSkuQty(2);
        orderMain.setGoodsQty(3);
        orderMain.setAmount(new BigDecimal(40));
        orderMain.setCreateTime(new Date());

        OrderDetail detail1 = new OrderDetail();
        detail1.setId(1l);
        detail1.setOrderNo(orderMain.getOrderNo());
        detail1.setGoodsNo("1234001");
        detail1.setGoodsName("ApplePhone");
        detail1.setQty(1);
        detail1.setPrice(new BigDecimal(20));
        detail1.setProductionDate(new Date());

        OrderDetail detail2 = new OrderDetail();
        detail2.setId(2l);
        detail2.setOrderNo(orderMain.getOrderNo());
        detail2.setGoodsNo("1234002");
        detail2.setGoodsName("HuaWeiPhone");
        detail2.setQty(2);
        detail2.setPrice(new BigDecimal(10));
        detail2.setProductionDate(new Date());

        List<OrderDetail> orderDetailList = Lists.newArrayList(detail1, detail2);
        orderMain.setOrderDetailList(orderDetailList);

        String s = JSON.toJSONString(orderMain);
        return s;
    }

}
