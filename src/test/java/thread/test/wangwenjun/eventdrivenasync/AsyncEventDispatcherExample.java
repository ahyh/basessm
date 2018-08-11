package thread.test.wangwenjun.eventdrivenasync;

import thread.test.wangwenjun.eventdriven.EventDispatcherExample;
import thread.test.wangwenjun.eventdriven.MessageEvent;

import java.util.concurrent.TimeUnit;

/**
 * 异步任务分发测试
 */
public class AsyncEventDispatcherExample {

    public static class AsyncInputEventHandler extends AsyncChannel {

        private final AsycnEventDispatcher dispatcher;

        public AsyncInputEventHandler(AsycnEventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        @Override
        protected void handle(MessageEvent message) {
            EventDispatcherExample.InputEvent inputEvent = (EventDispatcherExample.InputEvent) message;
            System.out.printf("X:%d,Y:%d\n", inputEvent.getX(), inputEvent.getY());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int result = inputEvent.getY() + inputEvent.getX();
            dispatcher.dispatch(new EventDispatcherExample.ResultEvent(result));
        }
    }

    public static class AsyncResultEventHandler extends AsyncChannel {

        @Override
        protected void handle(MessageEvent message) {
            EventDispatcherExample.ResultEvent resultEvent = (EventDispatcherExample.ResultEvent) message;
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("The result is:" + resultEvent.getResult());
        }
    }

    public static void main(String[] args) {
        AsycnEventDispatcher dispatcher = new AsycnEventDispatcher();
        dispatcher.registerChannel(EventDispatcherExample.InputEvent.class, new AsyncInputEventHandler(dispatcher));
        dispatcher.registerChannel(EventDispatcherExample.ResultEvent.class, new AsyncResultEventHandler());
        dispatcher.dispatch(new EventDispatcherExample.InputEvent(1, 5));
    }
}
