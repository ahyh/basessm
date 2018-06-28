package jdk.test;

import java.io.Serializable;
import java.util.List;

/**
 * Cloneable接口测试，没有实现Cloneable
 */
public class Library implements Cloneable, Serializable {

    private Long id;

    private String name;

    private Manager manager;

    private List<Book> bookList;

    public Library() {
    }

    public Library(Long id, String name, Manager manager, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.bookList = bookList;
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    /**
     * 重写克隆方法，还是调用父类Object的方法
     * 如果该类不实现Cloneable接口那么运行到这里就会报错
     * 抛出java.lang.CloneNotSupportedException
     *
     * @return
     */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
