package thinking.inJava.innerClass;

import org.junit.Test;

/**
 * Thinking in Java:内部类例2
 */
public class DotThis {

    public void fun() {
        System.out.println("DotThis fun");
    }

    private class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    /**
     * 静态内部类
     */
    private static class InnerStatic {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        Inner inner = dotThis.inner();
        DotThis outer = inner.outer();
        outer.fun();
        /**
         * 返回true：从内部类的实例可以获取到外部类的实例
         */
        System.out.println(dotThis == outer);
    }

    /**
     * 通过外部类对象.new的方式创建内部类对象
     */
    @Test
    public void testInner() {
        DotThis dotThis = new DotThis();
        Inner inner = dotThis.new Inner();
        System.out.println(inner);
    }

    @Test
    public void testInnerStatic(){
        InnerStatic innerStatic1 = new DotThis.InnerStatic();
        InnerStatic innerStatic2 = new DotThis.InnerStatic();
        System.out.println(innerStatic1 == innerStatic2); //返回false
    }
}
