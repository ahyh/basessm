package com.yanhuan.yhssm.test;

import com.google.common.collect.Lists;
import com.yanhuan.yhssm.domain.pojo.Bill;
import com.yanhuan.yhssm.domain.pojo.BillSubDetail;
import com.yanhuan.yhssm.domain.pojo.BillSubMain;
import com.yanhuan.yhssm.service.BillService;
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
public class BillServiceTest extends BaseTest {

    private static Logger logger = LogManager.getLogger(BillServiceTest.class);

    @Resource
    protected BillService billService;

    @Test
    public void testInsertBatch() {
        List<BillSubDetail> billSubDetailList1 = new ArrayList<>();
        BillSubDetail detail1 = new BillSubDetail();
        detail1.setSubMainNo("1001");
        detail1.setGoodsNo("123001");
        detail1.setGoodsName("aaaa");
        detail1.setQty(2);
        detail1.setPrice(new BigDecimal(20.0));
        detail1.setCreateUser("yanhuan");
        billSubDetailList1.add(detail1);
        BillSubDetail detail2 = new BillSubDetail();
        detail2.setSubMainNo("1001");
        detail2.setGoodsNo("123002");
        detail2.setGoodsName("bbbb");
        detail2.setQty(3);
        detail2.setPrice(new BigDecimal(30.0));
        detail2.setCreateUser("yanhuan");
        billSubDetailList1.add(detail2);

        BillSubMain billSubMain = new BillSubMain();
        billSubMain.setBillNo("111111");
        billSubMain.setSubMainNo("1001");
        billSubMain.setDetailQty(2);
        billSubMain.setAmount(new BigDecimal(130.0));
        billSubMain.setBillSubDetailList(billSubDetailList1);
        billSubMain.setCreateUser("yanhuan");


        List<BillSubDetail> billSubDetailList2 = new ArrayList<>();
        BillSubDetail detail3 = new BillSubDetail();
        detail3.setSubMainNo("2001");
        detail3.setGoodsNo("223001");
        detail3.setGoodsName("ccccc");
        detail3.setQty(2);
        detail3.setPrice(new BigDecimal(20.0));
        detail3.setCreateUser("yanhuan");
        billSubDetailList2.add(detail3);
        BillSubDetail detail4 = new BillSubDetail();
        detail4.setSubMainNo("20021");
        detail4.setGoodsNo("223002");
        detail4.setGoodsName("ffff");
        detail4.setQty(3);
        detail4.setPrice(new BigDecimal(30.0));
        detail4.setCreateUser("yanhuan");
        billSubDetailList2.add(detail4);

        BillSubMain billSubMain1 = new BillSubMain();
        billSubMain1.setBillNo("111111");
        billSubMain1.setSubMainNo("2002");
        billSubMain1.setDetailQty(2);
        billSubMain1.setAmount(new BigDecimal(130.0));
        billSubMain1.setBillSubDetailList(billSubDetailList2);
        billSubMain1.setCreateUser("yanhuan");
        List<BillSubMain> billSubMainList = Lists.newArrayList(billSubMain, billSubMain1);

        Bill bill = new Bill();
        bill.setBillNo("111111");
        bill.setMainQty(2);
        bill.setStatus((byte) 1);
        bill.setCreateUser("yanhuan");
        bill.setBillSubMainList(billSubMainList);

        Integer a = billService.insert(bill);

    }

    @Test
    public void testGet() {
        Bill billWithSubs = billService.getBillWithSubs(2l);
        System.out.println(billWithSubs);
    }

}
