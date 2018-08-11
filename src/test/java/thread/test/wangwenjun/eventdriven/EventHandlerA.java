package thread.test.wangwenjun.eventdriven;

public class EventHandlerA {

    public static void handleEvent(Event event){
        System.out.println(event.getData().toLowerCase());
    }
}
