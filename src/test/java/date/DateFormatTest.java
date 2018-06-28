package date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试日期的线程安全问题
 * Created by yanhuan1 on 2018/1/29.
 */
public class DateFormatTest extends Thread {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) {
        DateFormatTest test = new DateFormatTest();
        Thread t1 = new Thread(test, "t1");
        Thread t2 = new Thread(test, "t2");
        Thread t3 = new Thread(test, "t3");
        Thread t4 = new Thread(test, "t4");
        Thread t5 = new Thread(test, "t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public void run() {
        try {
            Date date = sdf.parse("20181128");
            String s = sdf.format(date);
           // sleep((int) (2000 * Math.random()));
            System.out.println(Thread.currentThread().getName() + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
