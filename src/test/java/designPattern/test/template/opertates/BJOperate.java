package designPattern.test.template.opertates;

import designPattern.test.template.AbstractOperate;
import designPattern.test.template.commons.OperateUtil;
import designPattern.test.template.pojo.OrderMain;

import java.util.Date;
import java.util.Map;

/**
 * 具体的实现类，各个地方有自己的处理方法，北京有北京的方法
 */
public class BJOperate extends AbstractOperate {

    /**
     * BJOperate具体的逻辑 operate2
     */
    @Override
    public void operate2(Map<String, Object> map) {
        try {
            Boolean resultCode = (Boolean) map.get(OperateUtil.RESULT_CODE);
            if (resultCode) {
                OrderMain orderMain = (OrderMain) map.get(OperateUtil.RESULT_VAULE);
                System.out.println("北京纯爷们！");
                System.out.println("BJOperate orderNo:" + orderMain.getOrderNo() + "operate2 is operating!");
            }else{
                System.out.println("BJOperate resultCode is false");
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
                System.out.println("北京纯爷们！");
                System.out.println("BJOperate orderNo:" + orderMain.getOrderNo() + "createTime is " + createTime + "!");
                System.out.println("BJOperate orderNo:" + orderMain.getOrderNo() + "operate3 is operating!");
            } else{
                System.out.println("BJOperate resultCode is false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
