package com.yanhuan.yhssm.utils;

import org.krysalis.barcode4j.ChecksumMode;
import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * 生成barcode工具类
 *
 * @author yanhuan1
 */
public class BarcodeUtil {

    /**
     * 生成文件barcode图片文件
     */
    public static void generateFile(String msg, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(path));
            if (StringUtils.isEmpty(msg) || fos == null) {
                throw new Exception("条形码内容或文件保存路径无效");
            }
            // 采用Code39编码
            Code39Bean bean = new Code39Bean();
            bean.setHeight(50.0);
            bean.setModuleWidth(0.29);
            bean.setWideFactor(4);
            bean.setIntercharGapWidth(1.0);
            bean.setQuietZone(10.0);
            bean.setChecksumMode(ChecksumMode.CP_AUTO);
            bean.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
            bean.setFontName("black");
            bean.setFontSize(8.0);
            bean.setDisplayStartStop(false);
            bean.setDisplayChecksum(false);
            String format = "image/png";
            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(fos, format, 200,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);
            // 生成条形码
            bean.generateBarcode(canvas, msg);
            // 结束绘制
            canvas.finish();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据msg生成BufferedImage对象用于打印
     *
     * @param msg 生成条形码的内容
     * @return BufferedImage对象用于给打印机发送入参
     */
    public static BufferedImage buildBufferedImage(String msg) {
        try {
            // 采用Code39编码
            Code39Bean bean = new Code39Bean();
            bean.setHeight(50.0);
            bean.setModuleWidth(0.29);
            bean.setWideFactor(4);
            bean.setIntercharGapWidth(1.0);
            bean.setQuietZone(10.0);
            bean.setChecksumMode(ChecksumMode.CP_AUTO);
            bean.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
            bean.setFontName("black");
            bean.setFontSize(10.0);
            bean.setDisplayStartStop(false);
            bean.setDisplayChecksum(false);
            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(200,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);
            // 生成条形码
            bean.generateBarcode(canvas, msg);
            // 结束绘制
            BufferedImage bufferedImage = canvas.getBufferedImage();
            return bufferedImage;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 竖直合并图片
     *
     * @param image 图片对象
     * @param qty   合并图片的数量
     * @return 合并后的图像
     */
    public static BufferedImage mergeImageVertical(BufferedImage image, Integer qty) {
        BufferedImage combined = new BufferedImage(image.getWidth(), image.getHeight() * qty, BufferedImage.TYPE_INT_RGB);
        Graphics g = combined.getGraphics();
        for (int i = 0; i < qty; i++) {
            g.drawImage(image, 0, image.getHeight() * i, null);
        }
        return combined;
    }

    /**
     * 水平合并图片
     *
     * @param image 图片对象
     * @param qty   合并图片的数量
     * @return
     */
    public static BufferedImage mergeImageHorizontal(BufferedImage image, Integer qty) {
        BufferedImage combined = new BufferedImage(image.getWidth() * qty, image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = combined.getGraphics();
        for (int i = 0; i < qty; i++) {
            g.drawImage(image, image.getWidth() * i, 0, null);
        }
        return combined;
    }


}
