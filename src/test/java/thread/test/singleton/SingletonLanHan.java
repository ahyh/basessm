package thread.test.singleton;

/**
 * final修饰的类不能被继承
 */
public final class SingletonLanHan {

    private byte[] data = new byte[1024];

    private static SingletonLanHan instance = null;

    /**
     * 私有化构造器
     */
    private SingletonLanHan() {

    }

    /**
     * 同步方法保证同时只能有一个线程执行此方法
     *
     * @return
     */
    public static synchronized SingletonLanHan getInstance() {
        if (instance == null) {
            instance = new SingletonLanHan();
        }
        return instance;
    }
}
