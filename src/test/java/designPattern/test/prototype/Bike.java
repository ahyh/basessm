package designPattern.test.prototype;

/**
 * 自行车对象
 */
public class Bike implements Product {

    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Bike() {
    }

    public Bike(String owner) {
        this.owner = owner;
    }

    @Override
    public void use(String s) {
        System.out.println("=====Bike====" + s);
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
