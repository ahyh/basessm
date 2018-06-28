package jdk.test;

import java.io.Serializable;

/**
 * 书的章节
 */
public class Chapter implements Serializable {

    //章节的名称
    private String name;

    //章节的字数
    private Integer size;

    //章节的页数
    private Integer pageQty;

    public Chapter() {
    }

    public Chapter(String name, Integer size, Integer pageQty) {
        this.name = name;
        this.size = size;
        this.pageQty = pageQty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPageQty() {
        return pageQty;
    }

    public void setPageQty(Integer pageQty) {
        this.pageQty = pageQty;
    }
}
