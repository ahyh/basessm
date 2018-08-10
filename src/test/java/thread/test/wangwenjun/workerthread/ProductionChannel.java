package thread.test.wangwenjun.workerthread;

public class ProductionChannel {

    /**
     * 传送带上最多可以有多少个代加工的产品
     */
    private final static int MAX_PROD = 100;

    /**
     * 用来存放待加工的产品，也就是传送带
     */
    private final Production[] productionQueue;

    private int tail;

    private int head;

    private int total;

    private final Worker[] workers;

    public ProductionChannel(int workerSize) {
        this.workers = new Worker[workerSize];
        this.productionQueue = new Production[MAX_PROD];
        //实例化每一个工人（worker线程）并且启动
        for (int i = 0; i < workerSize; i++) {
            workers[i] = new Worker("worker-" + i, this);
            new Thread(workers[i]).start();
        }
    }

    /**
     * 接收上游下发的半成品（待加工产品）
     *
     * @param production
     */
    public void offerProduction(Production production) {
        synchronized (this) {
            //当传送带上待加工的产品超过了最大值时阻塞上游再次下发半成品
            while (total > productionQueue.length) {
                try {
                    this.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            productionQueue[tail] = production;
            tail = (tail + 1) % productionQueue.length;
            total++;
            this.notifyAll();
        }
    }

    /**
     * 获取产品
     *
     * @return
     */
    public Production takeProduction() {
        synchronized (this) {
            //当传送带上没有产品时，工人等待产品从上游到传送带上
            while (total <= 0) {
                try {
                    this.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Production production = productionQueue[head];
            head = (head + 1) % productionQueue.length;
            total--;
            this.notifyAll();
            return production;
        }
    }
}
