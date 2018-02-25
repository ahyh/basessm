package designPattern.test.decorator.fileDecorator;

import org.junit.Test;

import java.io.*;

/**
 * io系统的装饰器应用
 */
public class FileTest {

    @Test
    public void testFileInputStream() throws Exception{
        long start = System.currentTimeMillis();
        InputStream inputStream = new FileInputStream(new File("D:/trace.log"));
        printLog(inputStream);
        System.out.println("============================Time:"+(System.currentTimeMillis() - start));
    }

    @Test
    public void testFileBuffered() throws Exception {
        long start = System.currentTimeMillis();
        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("D:/trace.log")));
        printLog(inputStream);
        System.out.println("============================Time:"+(System.currentTimeMillis() - start));
    }

    @Test
    public void testFileDataInputStream() throws Exception {
        long start = System.currentTimeMillis();
        InputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("D:/trace.log"))));
        printLog(inputStream);
        System.out.println("============================Time:"+(System.currentTimeMillis() - start));
    }

    private void printLog(InputStream inputStream) throws Exception{
        int i = 0;
        byte[] b = new byte[1024];
        while ((i = inputStream.read(b)) != -1) {
            String s = new String(b);
            System.out.println(s);
        }
    }

}
