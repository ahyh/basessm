package designPattern.test.facade;

import com.google.common.base.Preconditions;

/**
 * 服务B
 */
public class ServiceB {

    //方法1
    public Result method2(Param param) {
        Preconditions.checkNotNull(param);
        //处理自己的复杂的逻辑
        System.out.println("ServiceB method2 param invoked");
        return new Result(1, "调用ServiceB.method2方法成功", true);
    }
}
