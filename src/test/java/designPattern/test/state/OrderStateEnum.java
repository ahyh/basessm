package designPattern.test.state;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单状态枚举
 */
public enum OrderStateEnum {

    NEW((byte) 0, "新建"),
    HANDLING((byte) 1, "处理中"),
    FINISHED((byte) 2, "完成"),
    CANCEL((byte) 3, "取消");

    public static final Map<Byte, OrderStateEnum> orderStateEnumMap = new HashMap<Byte, OrderStateEnum>();

    static {
        for (OrderStateEnum e : EnumSet.allOf(OrderStateEnum.class)) {
            orderStateEnumMap.put(e.getKey(), e);
        }
    }

    public static OrderStateEnum getByCode(Byte code) {
        return orderStateEnumMap.get(code);
    }

    private Byte key;
    private String text;

    private OrderStateEnum(Byte key, String text) {
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
