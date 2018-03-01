package designPattern.test.iterator;

import java.io.Serializable;

/**
 * 图书类
 */
public class Book implements Serializable {

    private Long id;
    private String name;
    private String isbn;

    public Book() {
    }

    public Book(Long id, String name, String isbn) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
