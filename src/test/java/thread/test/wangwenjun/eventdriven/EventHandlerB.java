package thread.test.wangwenjun.eventdriven;

public class EventHandlerB {

    public static void handleEvent(Event event) {
        System.out.println(event.getData().toUpperCase());
    }
}
