package thread.test.singleton;

public final class SingletonEHan {

    private byte[] data = new byte[1024];

    private static SingletonEHan instance = new SingletonEHan();

    /**
     * 私有化构造函数，不允许外部new
     */
    private SingletonEHan() {
    }

    /**
     * 静态方法获取单例对象
     *
     * @return instance
     */
    public static SingletonEHan getInstance() {
        return instance;
    }
}
