package designPattern.test.flyweight;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 享元模式测试
 */
public class FlyWeightTest {

    private static PublisherFactory factory = new PublisherFactory();

    @Test
    public void testFlyWeight(){
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        book1.setId(1l);
        book1.setAuthor("罗贯中");
        book1.setBookName("三国演义");
        book1.setIsbn("1234567001");
        book1.setPrice(new BigDecimal(20.50));
        book1.setPublisher(factory.getPublisher(1l));

        book2.setId(2l);
        book2.setAuthor("曹雪芹");
        book2.setBookName("红楼梦");
        book2.setIsbn("1234567002");
        book2.setPrice(new BigDecimal(25.50));
        book2.setPublisher(factory.getPublisher(1l));

        book3.setId(1l);
        book3.setAuthor("施耐庵");
        book3.setBookName("水浒传");
        book3.setIsbn("1234567003");
        book3.setPrice(new BigDecimal(30.50));
        book3.setPublisher(factory.getPublisher(1l));

        book4.setId(1l);
        book4.setAuthor("吴承恩");
        book4.setBookName("西游记");
        book4.setIsbn("1234567004");
        book4.setPrice(new BigDecimal(23.50));
        book4.setPublisher(factory.getPublisher(1l));

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);

    }


}
