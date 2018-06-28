package designPattern.test.visitor;

import org.junit.Test;

/**
 * 访问者模式测试
 */
public class VisitorTest {

    @Test
    public void testVisitor() {
        Visitor visitorA = new PatternAVisitor();
        Visitor visitorB = new PatternBVisitor();
        File txtFile = new TxtFile("C://a//b.txt", 5000l);
        File picFile = new PictureFile("D://img//mm.jpg", 1024l);
        txtFile.accept(visitorA);
        picFile.accept(visitorB);
    }
}
