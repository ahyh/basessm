package designPattern.test.flyweight;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 图书类
 */
public class Book implements Serializable{

    //图书ID
    private Long id;

    //作者
    private String author;

    //书名
    private String bookName;

    //价格
    private BigDecimal price;

    //ISBN号
    private String isbn;

    //出版社
    private Publisher publisher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
