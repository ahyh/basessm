package thread.test.wangwenjun.threadpermessage;

import java.util.concurrent.TimeUnit;

/**
 * 任务处理器，一个任务需要一个线程进行处理
 *
 * @author yanhuan1
 */
public class TaskHandler implements Runnable {

    private final Request request;

    public TaskHandler(Request request) {
        this.request = request;
    }

    /**
     * 任务处理逻辑
     */
    @Override
    public void run() {
        System.out.println("Begin handle:" + request);
        slowly();
        System.out.println("End handle:" + request);
    }

    private void slowly() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
