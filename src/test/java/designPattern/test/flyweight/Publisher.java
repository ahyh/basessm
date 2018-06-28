package designPattern.test.flyweight;

import java.io.Serializable;

/**
 * 出版社类，一个出版社可能对应很多的图书
 * 出版社相对来说就是一个固定的类，该对象的信息很少变化
 * 适合应用享元模式
 */
public class Publisher implements Serializable {

    //出版社ID
    private Long id;

    //出版社名称
    private String publisherName;

    //出版社联系人
    private String contactName;

    //出版社联系人电话
    private String contactPhone;

    //出版社地址
    private String address;

    //出版社邮编
    private String postCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
