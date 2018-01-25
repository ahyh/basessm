package com.yanhuan.yhssm.test;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.yanhuan.yhssm.domain.bussiness.Goods;
import com.yanhuan.yhssm.domain.bussiness.Store;
import com.yanhuan.yhssm.domain.condition.OrderMainCondition;
import com.yanhuan.yhssm.domain.condition.SalaryCondition;
import com.yanhuan.yhssm.domain.pojo.OrderDetail;
import com.yanhuan.yhssm.domain.pojo.OrderMain;
import com.yanhuan.yhssm.domain.pojo.Salary;
import com.yanhuan.yhssm.service.OrderMainService;
import com.yanhuan.yhssm.service.SalaryService;
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
public class OrderMainServiceTest extends BaseTest {

    @Resource
    private OrderMainService orderMainService;

    @Test
    public void testInsert() {
        OrderMain orderMain = new OrderMain();
        Store store = GenerateUtils.getStoreRandom();
        orderMain.setOrderNo(GenerateUtils.getBizNo());
        orderMain.setOrderType((byte) 0);
        orderMain.setOrderStatus((byte) 0);
        orderMain.setPayStatus((byte) 0);
        orderMain.setSkuCount(5);
        orderMain.setGoodsCount(10);
        orderMain.setBuyer(GenerateUtils.getNameRandom());
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
        List<OrderDetail> orderDetailList = getOrderDetailList(orderMain, orderMain.getSkuCount());
        orderMain.setOrderDetailList(orderDetailList);
        Boolean insert = orderMainService.insert(orderMain);
        Assert.assertTrue(insert);
    }

    @Test
    public void testUpdate(){
        OrderMain orderMain = new OrderMain();
        orderMain.setId(7l);
        orderMain.setOrderType((byte)1);
        orderMain.setOrderStatus((byte)1);
        orderMain.setPayWayType((byte)2);
        orderMain.setUpdateUser("huanyan");
        Integer update = orderMainService.update(orderMain);
        Assert.assertTrue(update == 1);
    }

    @Test
    public void testDelete(){
        Long id = 7l;
        Boolean delete = orderMainService.delete(id);
        Assert.assertTrue(delete);
    }

    @Test
    public void testGetByCondition(){
        OrderMainCondition condition = new OrderMainCondition();
        condition.setId(8l);
        condition.setOrderNo("1516501188423");
        OrderMain orderMain = orderMainService.getOrderMainByCondition(condition);
        Assert.assertTrue(orderMain.getSkuCount() == orderMain.getOrderDetailList().size());
    }


    private List<OrderDetail> getOrderDetailList(OrderMain orderMain, int num) {
        List<OrderDetail> orderDetailList = new ArrayList<>(num);
        List<Goods> goodsList = GenerateUtils.getGoodsListRandom(num);
        OrderDetail detail;
        for (Goods goods : goodsList) {
            detail = new OrderDetail();
            setOrderDetailProp(detail, goods, orderMain);
            orderDetailList.add(detail);
        }
        return orderDetailList;
    }

    private void setOrderMainProp(OrderMain orderMain, Store store) {
        orderMain.setProvinceNo(store.getProvinceNo());
        orderMain.setProvinceName(store.getProvinceName());
        orderMain.setCityNo(store.getCityNo());
        orderMain.setCityName(store.getCityName());
        orderMain.setStoreNo(store.getStoreNo());
        orderMain.setStoreName(store.getStoreName());
    }

    private void setOrderDetailProp(OrderDetail detail, Goods goods, OrderMain orderMain) {
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
        detail.setOrderNo(orderMain.getOrderNo());
        detail.setProvinceNo(orderMain.getProvinceNo());
        detail.setProvinceName(orderMain.getProvinceName());
        detail.setCityNo(orderMain.getCityNo());
        detail.setCityName(orderMain.getCityName());
        detail.setStoreNo(orderMain.getStoreNo());
        detail.setStoreName(orderMain.getStoreName());
        detail.setQty(2);
        detail.setCreateTime(orderMain.getCreateTime());
        detail.setCreateUser(orderMain.getCreateUser());
    }

}
