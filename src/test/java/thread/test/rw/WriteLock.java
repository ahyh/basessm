package thread.test.rw;

/**
 * 写锁
 */
public class WriteLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    public WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }


    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getLock()) {
            try {
                //等待获取写锁的的数字加1
                readWriteLock.incrementWaitingWriters();
                //如果当前有线程在进行读操作或者写操作，则线程挂起
                while (readWriteLock.getReadingReaders() > 0
                        || readWriteLock.getWritingWriters() > 0) {
                    readWriteLock.getLock().wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.readWriteLock.decrementWritingWriters();
            }
            this.readWriteLock.incrementWritingWriters();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getLock()) {
            readWriteLock.decrementWritingWriters();
            readWriteLock.changePrefer(false);
            readWriteLock.getLock().notifyAll();
        }
    }
}
