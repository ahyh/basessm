package designPattern.test.template;

import com.alibaba.fastjson.JSON;
import designPattern.test.template.commons.OperateUtil;
import designPattern.test.template.pojo.OrderMain;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象的操作类，将重复的代码都放在这个抽象类中
 */
public abstract class AbstractOperate {

    /**
     * 此方法可以认为是所有的具体的实现类都具有相同实现的方法
     */
    public Map<String, Object> operate1(String msg) {
        Map<String, Object> resultMap = new HashMap<>();
        OrderMain orderMain = JSON.parseObject(msg, OrderMain.class);
        //operate1具体的操作，可以是把数据落库或其他
        System.out.println(orderMain.getOrderNo() + ":" + orderMain.getSkuQty());
        resultMap.put(OperateUtil.RESULT_CODE, Boolean.TRUE);
        resultMap.put(OperateUtil.RESULT_VAULE, orderMain);
        return resultMap;
    }

    /**
     * 此方法可以认为是所有的具体的实现类都具有不同实现的方法
     * 具体的实现放在子类中
     */
    public abstract void operate2(Map<String, Object> map);

    /**
     * 此方法可以认为是所有的具体的实现类都具有不同实现的方法
     * 具体的实现放在子类中
     */
    public abstract void operate3(Map<String, Object> map);

    public void operate4(String msg) {

        //1-所有的实现类都相同的处理
        Map<String, Object> resultMap = operate1(msg);

        //2-抽象方法2，具体业务逻辑在子类中
        operate2(resultMap);

        //3-抽象方法3，具体业务逻辑在子类中
        operate3(resultMap);

        //4-所有实现类相同的结束处理逻辑
        System.out.println("处理完成");
    }

}
