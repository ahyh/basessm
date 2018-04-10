package thinking.inJava.innerClass;

/**
 * 测试接口内部定义的类
 */
public class TestClassInterface implements ClassInterface {

    @Override
    public void howdy() {
        System.out.println("Outer TestClassInterface!");
    }

    public static void main(String[] args) {
        TestClassInterface testClassInterface = new TestClassInterface();
        testClassInterface.howdy();
        ClassInterface.TestClassInterface.main(null);
    }
}
