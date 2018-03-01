package designPattern.test.iterator;

/**
 * 书架:Book迭代器
 */
public class BookShelfIterator implements Iterator<Book> {

    //书架
    private BookShelf bookShelf;

    //元素下标
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    /**
     * 是否有下一个元素
     */
    public boolean hasNext() {
        if (this.index < bookShelf.getLength()) {
            return true;
        }
        return false;
    }

    /**
     * 返回下一个元素
     */
    public Book next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
