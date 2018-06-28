package guava.test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 定义的OrderBean，需要对这个Bean进行排序
 */
public class OrderBean {

    private Long id;

    private String orderNo;

    private Date createTime;

    private Date finishTime;

    private Integer qty;

    private BigDecimal amount;

    public OrderBean() {
    }

    public OrderBean(Long id, String orderNo, Date createTime, Date finishTime, Integer qty, BigDecimal amount) {
        this.id = id;
        this.orderNo = orderNo;
        this.createTime = createTime;
        this.finishTime = finishTime;
        this.qty = qty;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", createTime=" + createTime +
                ", finishTime=" + finishTime +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}
