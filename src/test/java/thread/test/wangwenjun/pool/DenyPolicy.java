package thread.test.wangwenjun.pool;

@FunctionalInterface
public interface DenyPolicy {

    void reject(Runnable runnable, MyThreadPool myThreadPool);

    /**
     * 该拒绝策略会直接将任务丢弃
     */
    class DiscardDenyPolicy implements DenyPolicy {
        @Override
        public void reject(Runnable runnable, MyThreadPool myThreadPool) {
            //do nothing
            System.out.println("Runnable is discard");
        }
    }

    /**
     * 该拒绝策略会向任务提交者抛出异常
     */
    class AbortDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, MyThreadPool myThreadPool) {
            throw new RunnableDenyException("The runnable " + runnable + " will be abort!");
        }
    }

    /**
     * 该拒绝策略会使任务在提交者所在线程中执行任务
     */
    class RunnerDenyPolicy implements DenyPolicy{

        @Override
        public void reject(Runnable runnable, MyThreadPool myThreadPool) {
            if(!myThreadPool.isShutDown()){
                runnable.run();
            }
        }
    }
}
