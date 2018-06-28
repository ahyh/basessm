package com.yanhuan.yhssm.test;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.yanhuan.yhssm.domain.condition.SalaryCondition;
import com.yanhuan.yhssm.domain.pojo.BillSubDetail;
import com.yanhuan.yhssm.domain.pojo.Salary;
import com.yanhuan.yhssm.service.BillSubDetailService;
import com.yanhuan.yhssm.service.SalaryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import utils.test.GenerateUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public class BillSubDetailServiceTest extends BaseTest {

    private static Logger logger = LogManager.getLogger(BillSubDetailServiceTest.class);

    @Resource
    protected BillSubDetailService billSubDetailService;

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
        detail2.setSubMainNo("1002");
        detail2.setGoodsNo("123002");
        detail2.setGoodsName("bbbb");
        detail2.setQty(3);
        detail2.setPrice(new BigDecimal(30.0));
        detail2.setCreateUser("yanhuan");
        billSubDetailList.add(detail2);

        Integer a = billSubDetailService.insertBatch(billSubDetailList);

    }

    @Test
    public void testInsert(){

        BillSubDetail detail1 = new BillSubDetail();
        detail1.setSubMainNo("1001");
        detail1.setGoodsNo("123001");
        detail1.setGoodsName("aaaa");
        detail1.setQty(2);
        detail1.setPrice(new BigDecimal(20.0));
        detail1.setCreateUser("yanhuan");
        billSubDetailService.insert(detail1);


    }

}
