package designPattern.test.visitor;

/**
 * Created by yanhuan1 on 2018/2/27.
 */
public class PatternBVisitor extends Visitor {

    //对于被访问对象的具体处理
    @Override
    public void visitFile(File file) {
        if (file instanceof TxtFile) {
            System.out.println("以方式B方式文本文件" + file);
        } else if (file instanceof PictureFile) {
            System.out.println("以方式B方式图片文件" + file);
        } else {
            throw new RuntimeException("文件类型不正确");
        }
    }

    @Override
    public String toString() {
        return "PatternB";
    }
}
