package files;

import com.google.common.collect.Lists;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;


public class Base64Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Base64Test.class);

    @Test
    public void testStringUtils(){
        String contents = "yanhuan.。";
        boolean flag = StringUtils.endsWithAny(contents, ".", "。");
        System.out.println(flag);
    }

    @Test
    public void testBase64ToFile() throws Exception {
        File file = new File("F:\\test\\js_base64.txt");
        String str = FileUtils.readFileToString(file);

        byte[] bytes = Base64.decodeBase64(str);

        File pngFile = new File("F:\\test\\js_base64.png");

        FileUtils.writeByteArrayToFile(pngFile,bytes,true);

    }

    @Test
    public void testList() throws Exception {
        List<String> list = Lists.newArrayList("bb","cc");
        String s = list.get(2);
        System.out.println(s);
    }

    @Test
    public void testSplitT() throws Exception {
        String str = "aa\tbb\t\tcc\t";
        String[] split = str.split("\t");
        System.out.println(split.length);
    }

    @Test
    public void testWriteTxt() throws Exception {
        File file = new File("aaa.txt");
        List<String> list = Lists.newArrayList("aa", "bb", "你好");
        FileUtils.writeLines(file,list,true);
        byte[] bytes = FileUtils.readFileToByteArray(file);
//        file.delete();
        Thread.sleep(1000);
        System.out.println(bytes.length);
    }

    @Test
    public void testBase64() throws Exception {
        byte[] bytes = Base64.encodeBase64(FileUtils.readFileToByteArray(new File("F:\\test\\Word_orginal.png")));
        System.out.println(new String(bytes, Charset.forName("utf-8")));
//        Rectangle rectangle = new Rectangle(0, 0, 300, 900);
//        cutImage(bytes, new FileOutputStream(new File("F:\\Temp\\" + UUID.randomUUID().toString())), rectangle, "jpg");
//        System.out.println();
    }

    /**
     * <p>Title: cutImage</p>
     * <p>Description:  根据原图与裁切size截取局部图片</p>
     *
     * @param buf    源图片
     * @param output 图片输出流
     * @param rect   需要截取部分的坐标和大小
     * @param suffix ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
     */
    public static void cutImage(byte[] buf, OutputStream output, Rectangle rect, String suffix) {

        InputStream fis = new ByteArrayInputStream(buf);
        ImageInputStream iis = null;
        try {
            // 将FileInputStream 转换为ImageInputStream
            iis = ImageIO.createImageInputStream(fis);
            // 根据图片类型获取该种类型的ImageReader
            ImageReader reader = ImageIO.getImageReadersBySuffix(suffix).next();
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0, param);
            ImageIO.write(bi, suffix, output);
        } catch (Exception ignored) {
            LOGGER.error("ignored:", ignored);
        } finally {
            try {
                fis.close();
                if (iis != null) iis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testGetExtension() throws Exception {
        String extension = null;
        FileInputStream fis = new FileInputStream(new File("F:\\test\\aaa.jpg"));
        byte[] bs = new byte[1];
        fis.read(bs);
        String type = Integer.toHexString(bs[0] & 0xFF);
        if ("ff".equalsIgnoreCase(type)) {
            extension = "JPEG";
        }
        if ("89".equalsIgnoreCase(type)) {
            extension = "PNG";
        }
        System.out.println(extension);
    }

}
