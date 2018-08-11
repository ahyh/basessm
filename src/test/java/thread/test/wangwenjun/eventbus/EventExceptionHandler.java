package thread.test.wangwenjun.eventbus;

/**
 * 异常处理器
 *
 * @author yanhuan1
 */
public interface EventExceptionHandler {

    void handle(Throwable cause, EventContext eventContext);
}
