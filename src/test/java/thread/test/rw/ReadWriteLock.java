package thread.test.rw;

public interface ReadWriteLock {

    /**
     * 创建读锁
     * @return
     */
    Lock readLock();

    /**
     * 创建写锁
     * @return
     */
    Lock writeLock();

    /**
     * 获取当前有多少线程正在执行写操作
     * @return
     */
    int getWritingWriters();

    int getWaitingWriters();

    /**
     * 获取当前有多少线程正在等待获取reader锁
     * @return
     */
    int getReadingReaders();

    /**
     * 工厂方法创建ReadWriteLock
     * @return
     */
    static ReadWriteLock readWriteLock(){
        return new ReadWriteLockImpl();
    }

    static ReadWriteLock readWriteLock(boolean preferWriter){
        return new ReadWriteLockImpl(preferWriter);
    }
}
