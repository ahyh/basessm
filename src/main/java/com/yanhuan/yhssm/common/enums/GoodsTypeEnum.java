package com.yanhuan.yhssm.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品类型枚举
 * Created by yanhuan1 on 2018/1/20.
 */
public enum GoodsTypeEnum {

    NOBOOK((byte) 0, "非图书商品"),
    BOOK((byte) 1, "图书商品");

    public static final Map<Byte, GoodsTypeEnum> GoodsTypeEnumMap = new HashMap<Byte, GoodsTypeEnum>();

    static {

        for (GoodsTypeEnum e : EnumSet.allOf(GoodsTypeEnum.class)) {
            GoodsTypeEnumMap.put(e.getKey(), e);
        }

    }

    public static GoodsTypeEnum getByCode(Byte code) {
        return GoodsTypeEnumMap.get(code);
    }

    private Byte key;
    private String text;

    private GoodsTypeEnum(Byte key, String text) {
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
