package designPattern.test.visitor;

/**
 * 图片文件
 */
public class PictureFile extends File {

    public PictureFile(String path, Long size) {
        super(path, size);
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println("设置图片文件访问方式......" + visitor);
        visitor.visitFile(this);
    }
}
