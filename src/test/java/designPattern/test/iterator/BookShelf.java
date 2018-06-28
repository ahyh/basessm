package designPattern.test.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 书架类
 */
public class BookShelf implements Aggregate {

    private List<Book> bookList;

    public BookShelf() {
        this.bookList = new ArrayList<>();
    }

    public Book getBookAt(int index) {
        return bookList.get(index);
    }

    public void appendBook(Book book) {
        this.bookList.add(book);
    }

    public int getLength() {
        return this.bookList.size();
    }

    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
