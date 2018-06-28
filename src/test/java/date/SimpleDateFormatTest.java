package date;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 测试SimpleDateFormat类的非线程安全性
 */
public class SimpleDateFormatTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 模拟并发环境下使用SimpleDateFormat的parse方法将字符串转换成Date对象
     */
    @Test
    public void testParse() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<String> dateStrList = Lists.newArrayList(
                "2018-04-01 10:00:01",
                "2018-04-02 11:00:02",
                "2018-04-03 12:00:03",
                "2018-04-04 13:00:04",
                "2018-04-05 14:00:05"
        );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (String str : dateStrList) {
            executorService.execute(() -> {
                try {
                    simpleDateFormat.parse(str);
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 测试SimpleDateFormat的format方法的线程安全性
     *
     * @throws Exception
     */
    @Test
    public void testFormat() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<String> dateStrList = Lists.newArrayList(
                "2018-04-01 10:00:01",
                "2018-04-02 11:00:02",
                "2018-04-03 12:00:03",
                "2018-04-04 13:00:04",
                "2018-04-05 14:00:05"
        );
        List<Date> dateList = new ArrayList<>();
        for (String str : dateStrList) {
            dateList.add(simpleDateFormat.parse(str));
        }
        Map<Date, Future<String>> map = new HashMap<>();
        for (Date date : dateList) {
            Future<String> submit = executorService.submit(() -> simpleDateFormat.format(date));
            map.put(date, submit);
        }
        System.out.println(map.get(dateList.get(4)).get());
    }

    /**
     * 模拟并发环境下使用SimpleDateFormat的parse方法将字符串转换成Date对象
     */
    @Test
    public void testParseThreadSafe() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<String> dateStrList = Lists.newArrayList(
                "2018-04-01 10:00:01",
                "2018-04-02 11:00:02",
                "2018-04-03 12:00:03",
                "2018-04-04 13:00:04",
                "2018-04-05 14:00:05"
        );
        for (String str : dateStrList) {
            executorService.execute(() -> {
                try {
                    //创建新的SimpleDateFormat对象用于日期-时间的计算
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    simpleDateFormat.parse(str);
                    TimeUnit.SECONDS.sleep(1);
                    simpleDateFormat = null; //销毁对象
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 日期
     */
    @Test
    public void testFormat1(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); //2018-04-17 10:06:22 12小时制
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())); //2018-04-17 10:06:22 24小时制
    }

}

