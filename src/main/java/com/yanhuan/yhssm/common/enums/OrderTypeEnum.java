package com.yanhuan.yhssm.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品类型枚举
 * Created by yanhuan1 on 2018/1/20.
 */
public enum OrderTypeEnum {

    OffLine((byte) 0, "线下订单"),
    OnSale((byte) 1, "促销订单"),
    FromJD((byte) 2, "京东转单"),
    FromTaobao((byte) 3, "淘宝转单");

    public static final Map<Byte, OrderTypeEnum> OrderTypeEnumMap = new HashMap<Byte, OrderTypeEnum>();

    static {

        for (OrderTypeEnum e : EnumSet.allOf(OrderTypeEnum.class)) {
            OrderTypeEnumMap.put(e.getKey(), e);
        }

    }

    public static OrderTypeEnum getByCode(Byte code) {
        return OrderTypeEnumMap.get(code);
    }

    private Byte key;
    private String text;

    private OrderTypeEnum(Byte key, String text) {
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
