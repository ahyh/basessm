package designPattern.test.facade;

import com.google.common.base.Preconditions;

/**
 * 服务C
 */
public class ServiceC {

    //方法1
    public Result method3(Param param) {
        Preconditions.checkNotNull(param);
        //处理自己的复杂的逻辑
        System.out.println("ServiceC method3 param invoked");
        return new Result(1, "调用ServiceC.method3方法成功", true);
    }
}
