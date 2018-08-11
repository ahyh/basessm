package thread.test.wangwenjun.eventdriven;

public class MessageEvent implements Message {

    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }
}
