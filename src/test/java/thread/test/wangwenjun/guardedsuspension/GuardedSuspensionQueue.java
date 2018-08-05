package thread.test.wangwenjun.guardedsuspension;

import java.util.LinkedList;

/**
 * 确保挂起
 *
 * @author yanhuan1
 */
public class GuardedSuspensionQueue {

    private final LinkedList<Integer> queue = new LinkedList<>();

    private final Integer LIMIT = 100;

    public void offer(Integer data) throws InterruptedException {
        synchronized (this) {
            //判断当前的queue中的元素个数是否超过了LIMIT
            while (queue.size() >= LIMIT) {
                //挂起使其阻塞
                this.wait();
            }
            //插入元素并唤醒其他线程
            queue.addLast(data);
            this.notifyAll();
        }
    }

    public Integer take() throws InterruptedException {
        synchronized (this) {
            //如果队列为空则阻塞
            while (queue.isEmpty()) {
                //挂起当前线程
                this.wait();
            }
            //通知其他线程可以继续插入数据
            this.notifyAll();
            return queue.removeFirst();
        }
    }
}
