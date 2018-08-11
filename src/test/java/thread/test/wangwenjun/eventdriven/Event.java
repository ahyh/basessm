package thread.test.wangwenjun.eventdriven;

/**
 * Event
 */
public class Event {

    private final String type;

    private final String data;

    public Event(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
