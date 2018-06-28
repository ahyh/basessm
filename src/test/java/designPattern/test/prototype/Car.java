package designPattern.test.prototype;

/**
 * 汽车对象
 */
public class Car implements Product {

    private String owner;

    public Car() {
    }

    public Car(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void use(String s) {
        System.out.println("=====Car====" + s);
    }

    //调用clone方法并返回
    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
