package designPattern.test.responsibilityChain;

import java.io.Serializable;
import java.util.Date;

/**
 * 申请，需要处理的对象
 */
public class Apply implements Serializable {

    //id
    private Long id;

    //申请人
    private String applier;

    //申请类型（1-休假申请，2-加班申请）
    private Byte applyType;

    //申请状态（0-初始，1-通过，2-驳回）
    private Byte applyStatus;

    //申请时长
    private Integer timeLength;

    //申请原因
    private String applyReason;

    //申请时间
    private Date applyTime;

    //处理时间
    private Date operateTime;

    //处理人
    private String operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplier() {
        return applier;
    }

    public void setApplier(String applier) {
        this.applier = applier;
    }

    public Byte getApplyType() {
        return applyType;
    }

    public void setApplyType(Byte applyType) {
        this.applyType = applyType;
    }

    public Byte getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Byte applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Integer getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", applier='" + applier + '\'' +
                ", applyType=" + applyType +
                ", applyStatus=" + applyStatus +
                ", timeLength=" + timeLength +
                ", applyReason='" + applyReason + '\'' +
                ", applyTime=" + applyTime +
                ", operateTime=" + operateTime +
                ", operator='" + operator + '\'' +
                '}';
    }
}
