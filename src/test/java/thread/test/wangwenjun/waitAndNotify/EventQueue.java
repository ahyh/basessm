package thread.test.wangwenjun.waitAndNotify;

import java.util.LinkedList;

public class EventQueue {

    private final int max;

    private static final int DEFAULT_MAX_EVENT = 100;

    static class Event {
        @Override
        public String toString() {
            return "event";
        }
    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    /**
     * 添加Event
     *
     * @param event
     */
    public void offer(Event event) {
        synchronized (eventQueue) {
            while (eventQueue.size() >= max) {
                try {
                    System.out.println("FULL");
                    eventQueue.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A new event is submitted");
            eventQueue.add(event);
            eventQueue.notifyAll();
        }
    }

    /**
     * 获取event
     *
     * @return event
     */
    public Event take() {
        synchronized (eventQueue) {
            while (eventQueue.isEmpty()) {
                try {
                    eventQueue.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Event take");
            Event event = eventQueue.removeFirst();
            eventQueue.notifyAll();
            return event;
        }
    }

}
