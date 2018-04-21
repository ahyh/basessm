package com.yanhuan.yhssm.test;

import com.yanhuan.yhssm.domain.pojo.BillSubDetail;
import com.yanhuan.yhssm.domain.pojo.BillSubMain;
import com.yanhuan.yhssm.service.BillSubDetailService;
import com.yanhuan.yhssm.service.BillSubMainService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public class BillSubMainServiceTest extends BaseTest {

    private static Logger logger = LogManager.getLogger(BillSubMainServiceTest.class);

    @Resource
    protected BillSubMainService billSubMainService;

    @Test
    public void testInsertBatch() {
        List<BillSubDetail> billSubDetailList = new ArrayList<>();
        BillSubDetail detail1 = new BillSubDetail();
        detail1.setSubMainNo("1001");
        detail1.setGoodsNo("123001");
        detail1.setGoodsName("aaaa");
        detail1.setQty(2);
        detail1.setPrice(new BigDecimal(20.0));
        detail1.setCreateUser("yanhuan");
        billSubDetailList.add(detail1);
        BillSubDetail detail2 = new BillSubDetail();
        detail2.setSubMainNo("1001");
        detail2.setGoodsNo("123002");
        detail2.setGoodsName("bbbb");
        detail2.setQty(3);
        detail2.setPrice(new BigDecimal(30.0));
        detail2.setCreateUser("yanhuan");
        billSubDetailList.add(detail2);

        BillSubMain billSubMain = new BillSubMain();
        billSubMain.setBillNo("111111");
        billSubMain.setSubMainNo("1001");
        billSubMain.setDetailQty(2);
        billSubMain.setAmount(new BigDecimal(130.0));
        billSubMain.setBillSubDetailList(billSubDetailList);
        billSubMain.setCreateUser("yanhuan");


        Integer a = billSubMainService.insert(billSubMain);

    }

    @Test
    public void testInsert() {


    }

}
