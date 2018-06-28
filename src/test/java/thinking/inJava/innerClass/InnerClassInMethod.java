package thinking.inJava.innerClass;

/**
 * Thinking in Java:定义在方法中的内部类
 */
public class InnerClassInMethod {

    /**
     * 定义在方法内部的内部类，作用域只在方法类有效
     * @return
     */
    public Selector inner(){
        class InnerSelector implements Selector{
            @Override
            public Boolean end() {
                return null;
            }

            @Override
            public Object current() {
                return null;
            }

            @Override
            public void next() {

            }
        }
        return new InnerSelector();
    }

    public static void main(String[] args) {
        InnerClassInMethod innerClassInMethod = new InnerClassInMethod();
        Selector inner = innerClassInMethod.inner();
        System.out.println(inner);
    }
}
