package utils.test;

import com.yanhuan.yhssm.utils.BarcodeUtil;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class BarcodeUtilTest {

    @Test
    public void testGenerateFile() {
        String msg = "000200098201741";
        String path = "D:\\jdgo\\barcode.png";
        BarcodeUtil.generateFile(msg, path);
    }

    @Test
    public void testGenerateBufferedImage() throws Exception {
        String msg = "000200098201743";
        BufferedImage bufferedImage = BarcodeUtil.buildBufferedImage(msg);
        File file = new File("D:\\jdgo\\save.png");
        ImageIO.write(bufferedImage, "png", file);
    }

    /**
     * 竖直图片合并测试
     *
     * @throws Exception
     */
    @Test
    public void testMergeBufferedImageVertical() throws Exception {
        String msg = "000200098201743";
        BufferedImage bufferedImage = BarcodeUtil.buildBufferedImage(msg);
        BufferedImage image = BarcodeUtil.mergeImageVertical(bufferedImage, 5);
        File file = new File("D:\\jdgo\\mergeV.png");
        ImageIO.write(image, "png", file);
    }
    /**
     * 竖直图片合并测试
     *
     * @throws Exception
     */
    @Test
    public void testMergeBufferedImage() throws Exception {
        String msg = "000200098201732";
        BufferedImage bufferedImage = BarcodeUtil.buildBufferedImage(msg);
        BufferedImage image = BarcodeUtil.mergeImageHorizontal(bufferedImage, 5);
        File file = new File("D:\\jdgo\\mergeH.png");
        ImageIO.write(image, "png", file);
    }
}
