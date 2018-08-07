package thread.test.rw;

/**
 * 读锁
 *
 * @author yanhuan1
 */
public class ReadLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        //如果此时有线程在进行写操作，或者有写操作在等待并且偏向写锁的标识为true时
        //就会无法获得读锁，只能被挂起
        synchronized (readWriteLock.getLock()) {
            while (readWriteLock.getWritingWriters() > 0
                    || (readWriteLock.getPerferWriter()
                    && readWriteLock.getWaitingWriters() > 0)) {
                readWriteLock.getLock().wait();
            }
            readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getLock()) {
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getLock().notifyAll();
        }
    }
}
