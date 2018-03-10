package jdk.test;

import com.google.common.collect.Lists;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * 深复制浅复制问题研究
 */
public class TestClone {

    @Test
    public void testBook() {
        Chapter chapter1 = new Chapter("第一章", 2500, 15);
        Chapter chapter2 = new Chapter("第二章", 2600, 16);
        Book book = new Book(1l, "三国演义", "罗贯中", Lists.newArrayList(chapter1, chapter2));
        Book cloneBook = (Book) book.clone();
        System.out.println(book == cloneBook);
        System.out.println(book.getChapterList() == cloneBook.getChapterList());

        //给book对象的chapterList加一个元素，可以看到cloneBook的chapter也变化了
        book.getChapterList().add(new Chapter("第三章", 2500, 15));
        System.out.println(cloneBook.getChapterList().size());
    }

    @Test
    public void testDeepClone() throws Exception{
        Chapter chapter1 = new Chapter("第一章", 2500, 15);
        Chapter chapter2 = new Chapter("第二章", 2600, 16);
        Book book = new Book(1l, "三国演义", "罗贯中", Lists.newArrayList(chapter1, chapter2));
        //将对象转换为字节流写入流中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);

        //从流里读出来
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Book cloneBook = (Book) ois.readObject();
        //关闭流
        baos.close();
        oos.close();
        bais.close();
        ois.close();

        /**
         * 此处如果没有实现Serializable接口，就会报错java.io.NotSerializableException
         * Library持有任何对象的类型都要实现Serializable接口，否则会报错
         */
        System.out.println(book == cloneBook);
        System.out.println(book.getChapterList() == cloneBook.getChapterList());
    }



//    @Test
//    public void testCloneable() throws Exception {
//        Manager manager = new Manager(1l, "Mao", 25);
//        Book book1 = new Book(1l, "三国演义", "罗贯中");
//        Book book2 = new Book(2l, "西游记", "吴承恩");
//        Book book3 = new Book(3l, "红楼梦", "曹雪芹");
//        Book book4 = new Book(4l, "水浒传", "施耐庵");
//        List<Book> bookList = Lists.newArrayList(book1, book2, book3, book4);
//        Library library = new Library(1l, "北大图书馆", manager, bookList);
//        Library cloneLibrary = (Library) library.clone();
//        //克隆出一个新的对象
//        System.out.println(library == cloneLibrary);
//        //内部的引用都指向一个对象,不管有没有实现Cloneable接口，这里就是浅复制
//        //任意一个对象的修改都会影响到另外一个，浅复制就是引用的复制
//        System.out.println(library.getId() == cloneLibrary.getId());
//        System.out.println(library.getManager() == cloneLibrary.getManager());
//        System.out.println(library.getBookList() == library.getBookList());
//    }
////
//    @Test
//    public void testDeepClone() throws Exception {
//        Manager manager = new Manager(1l, "Mao", 25);
//        Book book1 = new Book(1l, "三国演义", "罗贯中");
//        Book book2 = new Book(2l, "西游记", "吴承恩");
//        Book book3 = new Book(3l, "红楼梦", "曹雪芹");
//        Book book4 = new Book(4l, "水浒传", "施耐庵");
//        List<Book> bookList = Lists.newArrayList(book1, book2, book3, book4);
//        Library library = new Library(1l, "北大图书馆", manager, bookList);
//
//        //将对象转换为字节流写入流中
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(baos);
//        oos.writeObject(library);
//
//        //从流里读出来
//        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//        ObjectInputStream ois = new ObjectInputStream(bais);
//        Library cloneLalibrary = (Library) ois.readObject();
//        //关闭流
//        baos.close();
//        oos.close();
//        bais.close();
//        ois.close();
//
//        /**
//         * 此处如果没有实现Serializable接口，就会报错java.io.NotSerializableException
//         * Library持有任何对象的类型都要实现Serializable接口，否则会报错
//         */
//        System.out.println(library == cloneLalibrary);
//        System.out.println(library.getId() == cloneLalibrary.getId());
//        System.out.println(library.getName() == cloneLalibrary.getName());
//        System.out.println(library.getBookList() == cloneLalibrary.getBookList());
//    }
}
