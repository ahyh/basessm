package thread.test.wangwenjun.eventdriven;

public class EventDispatcherExample {

    public static class InputEvent extends MessageEvent {
        private final int x;
        private final int y;

        public InputEvent(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static class ResultEvent extends MessageEvent {
        private final int result;

        public ResultEvent(int result) {
            this.result = result;
        }

        public int getResult() {
            return this.result;
        }
    }

    public static class ResultEventHandler implements Channel<ResultEvent> {

        @Override
        public void dispatch(ResultEvent message) {
            System.out.println("The result is:" + message.getResult());
        }
    }

    public static class InputEventHandler implements Channel<InputEvent> {

        private final EventDispatcher dispatcher;

        public InputEventHandler(EventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        /**
         * 将计算结果构造成新的Event提交给Router
         *
         * @param message
         */
        @Override
        public void dispatch(InputEvent message) {
            System.out.printf("X:%d,Y:%d\n", message.getX(), message.getY());
            int result = message.getX() + message.getY();
            dispatcher.dispatch(new ResultEvent(result));
        }
    }

    public static void main(String[] args) {
        EventDispatcher eventDispatcher = new EventDispatcher();
        eventDispatcher.registerChannel(InputEvent.class, new InputEventHandler(eventDispatcher));
        eventDispatcher.registerChannel(ResultEvent.class, new ResultEventHandler());
        eventDispatcher.dispatch(new InputEvent(1, 2));
    }
}
