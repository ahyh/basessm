package designPattern.test.visitor;

/**
 * 文本文件
 */
public class TxtFile extends File {

    public TxtFile(String path, Long size) {
        super(path, size);
    }

    //根据传入的Visitor有不同的访问逻辑
    @Override
    public void accept(Visitor visitor) {
        System.out.println("设置文本文件访问方式......" + visitor);
        visitor.visitFile(this);
    }
}
