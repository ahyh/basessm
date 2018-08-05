package thread.test.singleton;

/**
 * 通过静态内配类的方式完成单例模式
 */
public final class SingletonHolder {

    private byte[] data = new byte[1024];

    private SingletonHolder() {

    }

    private static class Holder {
        private static SingletonHolder instance = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        return Holder.instance;
    }
}
