package designPattern.test.facade;

import com.google.common.base.Preconditions;

/**
 * 服务A
 */
public class ServiceA {

    //方法1
    public Result method1(Param param) {
        Preconditions.checkNotNull(param);
        //处理自己的复杂的逻辑
        System.out.println("ServiceA method1 param invoked");
        return new Result(1, "调用ServiceA.method1方法成功", true);
    }
}
