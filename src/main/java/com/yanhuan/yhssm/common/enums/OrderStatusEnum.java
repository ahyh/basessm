package com.yanhuan.yhssm.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品类型枚举
 * Created by yanhuan1 on 2018/1/20.
 */
public enum OrderStatusEnum {

    NewOrder((byte) 0, "新建单"),
    Pause((byte) 1, "暂停"),
    Cancel((byte) 2, "取消"),
    Ill((byte) 3, "病单");

    public static final Map<Byte, OrderStatusEnum> OrderStatusEnumMap = new HashMap<Byte, OrderStatusEnum>();

    static {

        for (OrderStatusEnum e : EnumSet.allOf(OrderStatusEnum.class)) {
            OrderStatusEnumMap.put(e.getKey(), e);
        }

    }

    public static OrderStatusEnum getByCode(Byte code) {
        return OrderStatusEnumMap.get(code);
    }

    private Byte key;
    private String text;

    private OrderStatusEnum(Byte key, String text) {
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
