package designPattern.test.facade;

/**
 * 统一对外的接口
 */
public class FacadeAPI {

    //ServiceA、ServiceB、ServiceC可以通过配置文件方式或者注解方式注入或者set方法注入
    //但是前提是这些对象都在Spring容器中管理了
    private ServiceA serviceA;

    private ServiceB serviceB;

    private ServiceC serviceC;

    public FacadeAPI() {
    }

    public FacadeAPI(ServiceA serviceA, ServiceB serviceB, ServiceC serviceC) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
        this.serviceC = serviceC;
    }

    //将复杂的处理逻辑封装起来对外暴露
    public Result handle(Param param) {
        Result resultA = serviceA.method1(param);
        if (resultA.isSuccessFlag()) {
            Result resultB = serviceB.method2(param);
            if (resultB.isSuccessFlag()) {
                Result resultC = serviceC.method3(param);
                if (resultC.isSuccessFlag()) {
                    return resultC;
                } else {
                    throw new RuntimeException("ServiceC run error!");
                }
            } else {
                throw new RuntimeException("ServiceB run error!");
            }
        } else {
            throw new RuntimeException("ServiceA run error!");
        }
    }

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public ServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public ServiceC getServiceC() {
        return serviceC;
    }

    public void setServiceC(ServiceC serviceC) {
        this.serviceC = serviceC;
    }
}
