package thinking.inJava.innerClass;

/**
 * 匿名内部类1
 */
class ServiceImplemention1 implements Service {

    /**
     * 使用private声明构造器方法，外部无法new
     */
    private ServiceImplemention1() {
    }

    @Override
    public void method1() {
        System.out.println("ServiceImplemention1 method1");
    }

    @Override
    public void method2() {
        System.out.println("ServiceImplemention1 method2");
    }

    public static ServiceFactory factory = () -> new ServiceImplemention1();
}

/**
 * 匿名内部类2
 */
class ServiceImplemention2 implements Service {

    /**
     * 使用private声明构造器方法，外部无法new
     */
    private ServiceImplemention2() {
    }

    @Override
    public void method1() {
        System.out.println("ServiceImplemention2 method1");
    }

    @Override
    public void method2() {
        System.out.println("ServiceImplemention2 method2");
    }

    public static ServiceFactory factory = () -> new ServiceImplemention2();
}

public class Factories {

    public static void main(String[] args) {
        service(ServiceImplemention1.factory);
        service(ServiceImplemention2.factory);
    }

    public static void service(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }
}
