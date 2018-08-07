package thread.test.future;

/**
 * @param <T>
 */
public class FutureTask<T> implements Future<T> {

    //计算结果
    private T result;

    //任务是否完成
    private boolean isDone = false;

    //定义对象锁
    private final Object LOCK = new Object();

    @Override
    public T get() throws InterruptedException {
        synchronized (LOCK) {
            //当任务还没有完成的时候调用get方法会进入阻塞
            while (!isDone) {
                LOCK.wait();
            }
            //返回最终计算结果
            return result;
        }
    }

    /**
     * 用于为FutureTask设置计算结果
     *
     * @param result
     */
    protected void finish(T result) {
        synchronized (LOCK) {
            if (isDone) {
                return;
            }
            //计算完成为result指定计算结果，并且将isDone设为true
            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }
    }

    @Override
    public boolean done() {
        return isDone;
    }
}
