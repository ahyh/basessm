package thread.test.wangwenjun.watchservice;

import thread.test.wangwenjun.eventbus.AsyncEventBus;
import thread.test.wangwenjun.eventbus.Subscribe;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FileChangeListener {

    @Subscribe
    public void onChange(FileChangeEvent event) {
        System.out.printf("%s-%s\n", event.getPath(), event.getKind());
    }

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        AsyncEventBus asyncEventBus = new AsyncEventBus(executor);
        asyncEventBus.register(new FileChangeListener());
        DirectoryTargetMonitor monitor = new DirectoryTargetMonitor(asyncEventBus, "D:\\export");
        monitor.startMonitor();
    }
}
