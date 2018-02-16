package designPattern.test.state;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单类，需要处理的对象
 */
public class Order implements Serializable {

    //订单编号
    private String orderNo;

    //下单人
    private String buyer;

    //订单状态（0-新建，1-处理中，2-完成，3-取消）
    private Byte status;

    //金额
    private BigDecimal money;

    //下单时间
    private Date createTime;

    public Order(){}

    public Order(String orderNo, String buyer, Byte status, BigDecimal money, Date createTime) {
        this.orderNo = orderNo;
        this.buyer = buyer;
        this.status = status;
        this.money = money;
        this.createTime = createTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
