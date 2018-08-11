package thread.test.wangwenjun.eventdriven;

public interface Message {

    /**
     * 返回Message类型
     *
     * @return Message或子类的类型
     */
    Class<? extends Message> getType();
}
