package thinking.inJava.innerClass;

/**
 * 接口内部定义的类
 */
public interface ClassInterface {

    void howdy();

    class TestClassInterface implements ClassInterface {

        @Override
        public void howdy() {
            System.out.println("TestClassInterface");
        }

        public static void main(String[] args) {
            new TestClassInterface().howdy();
        }
    }
}
