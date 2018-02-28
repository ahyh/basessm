package designPattern.test.adapter.file;

import org.junit.Test;

import java.io.*;

/**
 * InputStreamReader测试
 */
public class FileAdapterTest {

    /**
     * 适配器模式将一个InputStream接口适配成Reader接口
     */
    @Test
    public void testFileAdapter() throws Exception {
        long start = System.currentTimeMillis();
        Reader reader = new InputStreamReader(new FileInputStream(new File("D:/trace.log")));
        printLog(reader);
        System.out.println("============================Time:" + (System.currentTimeMillis() - start));
    }

    private void printLog(Reader reader) throws Exception {
        int i = 0;
        char[] chars = new char[1024];
        while ((i = reader.read(chars)) != -1) {
            String s = new String(chars);
            System.out.println(s);
        }
    }
}
