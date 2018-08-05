package thread.test.singleton;

/**
 * final修饰不可被继承
 */
public final class SingletonDoubleCheck {

    private byte[] data = new byte[1024];

    /**
     * 此处如果不用volatile修饰的话可能导致空指针异常，
     * 对象实例化了但是对象中的变量还没有实例化完成
     */
    private volatile static SingletonDoubleCheck instance = null;

    private SingletonDoubleCheck() {

    }

    public static SingletonDoubleCheck getInstance() {
        //instance为null时才进入同步代码块，避免了每次都要进入同步代码块，可以提高效率
        if (instance == null) {
            //只有一个线程能够获得SingletonDoubleCheck.class的锁
            synchronized (SingletonDoubleCheck.class) {
                //如果instance为null则创建新的对象
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
