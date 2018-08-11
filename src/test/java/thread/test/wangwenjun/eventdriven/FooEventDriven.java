package thread.test.wangwenjun.eventdriven;

import java.util.LinkedList;

public class FooEventDriven {

    public static void handleEventA(Event event){
        System.out.println(event.getData().toLowerCase());
    }

    public static void handleEventB(Event event) {
        System.out.println(event.getData().toUpperCase());
    }

    public static void main(String[] args) {
        LinkedList<Event> events = new LinkedList<>();
        events.add(new Event("A","Hello"));
        events.add(new Event("A","I am Event A"));
        events.add(new Event("B","I am Event B"));
        events.add(new Event("B","World"));
        events.add(new Event("A","Hello world"));
        Event e;
        while(!events.isEmpty()){
            e = events.remove();
            switch (e.getType()){
                case "A":
                    handleEventA(e);
                    break;
                case "B":
                    handleEventB(e);
                    break;
            }
        }
    }
}
