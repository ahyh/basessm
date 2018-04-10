package thinking.inJava.innerClass;

/**
 * 匿名内部类
 */
public class AnonymousInner {

    /**
     * 返回一个匿名的内部类
     *
     * @return
     */
    public Contents contents() {
        return new Contents() {
            int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        AnonymousInner anonymousInner = new AnonymousInner();
        Contents contents = anonymousInner.contents();
        System.out.println(contents.value());
    }
}
