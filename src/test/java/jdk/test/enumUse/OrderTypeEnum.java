package jdk.test.enumUse;

/**
 * 订单类型枚举
 */
public enum OrderTypeEnum {

    NORMALORDER("普通订单"),
    VIPORDER("VIP订单");

    private String description;

    /**
     * 此处只能定义为private
     *
     * @param description
     */
    OrderTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
