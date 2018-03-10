package jdk.test;

import java.io.Serializable;
import java.util.List;

/**
 * 图书类
 */
public class Book implements Cloneable,Serializable {

    private Long id;

    private String bookname;

    private String author;

    private List<Chapter> chapterList;

    public Book() {
    }

    public Book(Long id, String bookname, String author, List<Chapter> chapterList) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.chapterList = chapterList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    /**
     * 重写Object的clone方法
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
