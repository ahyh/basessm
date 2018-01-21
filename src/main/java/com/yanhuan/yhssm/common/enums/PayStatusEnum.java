package com.yanhuan.yhssm.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品类型枚举
 * Created by yanhuan1 on 2018/1/20.
 */
public enum PayStatusEnum {

    NonPay((byte) 0, "未支付"),
    Paid((byte) 1, "已支付"),
    Refunding((byte) 2, "退款中"),
    Refunded((byte) 3, "已退款"),
    Cancel((byte) 4, "订单取消");

    public static final Map<Byte, PayStatusEnum> OrderStatusEnumMap = new HashMap<Byte, PayStatusEnum>();

    static {

        for (PayStatusEnum e : EnumSet.allOf(PayStatusEnum.class)) {
            OrderStatusEnumMap.put(e.getKey(), e);
        }

    }

    public static PayStatusEnum getByCode(Byte code) {
        return OrderStatusEnumMap.get(code);
    }

    private Byte key;
    private String text;

    private PayStatusEnum(Byte key, String text) {
        this.key = key;
        this.text = text;
    }

    public Byte getKey() {
        return key;
    }

    public void setKey(Byte key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
