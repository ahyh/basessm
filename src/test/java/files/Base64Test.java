package files;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;


public class Base64Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Base64Test.class);

    @Test
    public void testBase64() throws Exception {
        byte[] bytes = Base64.encodeBase64(FileUtils.readFileToByteArray(new File("F:\\test\\000.jpg")));
        System.out.println(new String(bytes));
        Rectangle rectangle = new Rectangle(0, 0, 300, 900);
        cutImage(bytes, new FileOutputStream(new File("F:\\Temp\\" + UUID.randomUUID().toString())), rectangle, "jpg");
        System.out.println();
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
        String type = Integer.toHexString(bs[0]&0xFF);
        if("ff".equalsIgnoreCase(type)){
            extension = "JPEG";
        }
        if("89".equalsIgnoreCase(type)) {
            extension = "PNG";
        }
        System.out.println(extension);
    }

}
