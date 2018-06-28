package designPattern.test.iterator;

import org.junit.Test;

/**
 * 迭代器模式测试
 */
public class IteratorTest {

    @Test
    public void testIterator() {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book((long) 1, "西游记", "96123456781"));
        bookShelf.appendBook(new Book((long) 2, "三国演义", "96123456782"));
        bookShelf.appendBook(new Book((long) 3, "水浒传", "96123456783"));
        bookShelf.appendBook(new Book((long) 4, "红楼梦", "96123456784"));
        bookShelf.appendBook(new Book((long) 5, "红楼梦1", "96123456785"));
        bookShelf.appendBook(new Book((long) 6, "红楼梦2", "96123456786"));
        Iterator iterator = new BookShelfIterator(bookShelf);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
