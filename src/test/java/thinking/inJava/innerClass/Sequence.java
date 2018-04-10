package thinking.inJava.innerClass;

/**
 * Thinking in Java：内部类例1
 */
public class Sequence {

    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object item) {
        if (next < items.length) {
            items[next++] = item;
        }
    }

    /**
     * 内部类实现外部的接口
     */
    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public Boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
