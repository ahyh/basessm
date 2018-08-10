package thread.test.wangwenjun.threadpermessage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Operator {

//    /**
//     * 每一个Request创建一个新的线程
//     * @param message
//     */
//    public void call(String message){
//        //为每一个请求创建一个线程去处理
//        TaskHandler taskHandler = new TaskHandler(new Request(message));
//        new Thread(taskHandler).start();
//    }

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void call(String message){
        TaskHandler taskHandler = new TaskHandler(new Request(message));
        executorService.execute(taskHandler);
    }
}
