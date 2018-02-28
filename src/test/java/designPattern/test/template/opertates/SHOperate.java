package designPattern.test.template.opertates;

import designPattern.test.template.AbstractOperate;
import designPattern.test.template.commons.OperateUtil;
import designPattern.test.template.pojo.OrderMain;

import java.util.Date;
import java.util.Map;

/**
 * 上海的具体处理逻辑
 */
public class SHOperate extends AbstractOperate {

    /**
     * BJOperate具体的逻辑 operate2
     */
    @Override
    public void operate2(Map<String, Object> map) {
        try {
            Boolean resultCode = (Boolean) map.get(OperateUtil.RESULT_CODE);
            if (resultCode) {
                OrderMain orderMain = (OrderMain) map.get(OperateUtil.RESULT_VAULE);
                //具体的不同逻辑
                System.out.println("阿拉是上海人!");
                System.out.println("SHOperate orderNo:" + orderMain.getOrderNo() + "operate2 is operating!");
            } else{
                System.out.println("SHOperate resultCode is false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * BJOperate具体的逻辑 operate3
     */
    @Override
    public void operate3(Map<String, Object> map) {
        try {
            Boolean resultCode = (Boolean) map.get(OperateUtil.RESULT_CODE);
            if (resultCode) {
                OrderMain orderMain = (OrderMain) map.get(OperateUtil.RESULT_VAULE);
                Date createTime = orderMain.getCreateTime();
                //具体的不同逻辑
                System.out.println("阿拉是上海人!");
                System.out.println("SHOperate orderNo:" + orderMain.getOrderNo() + "createTime is " + createTime + "!");
                System.out.println("SHOperate orderNo:" + orderMain.getOrderNo() + "operate3 is operating!");
            }else{
                System.out.println("SHOperate resultCode is false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
