package thread.test.wangwenjun.pool;

/**
 * 自定义一个任务拒绝执行的异常
 *
 * @author yanhuan1
 */
public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }
}
