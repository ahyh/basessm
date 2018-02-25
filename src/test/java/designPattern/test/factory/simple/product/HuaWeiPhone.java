package designPattern.test.factory.simple.product;

/**
 * 华为手机
 */
public class HuaWeiPhone extends BasePhone implements Phone {

    public HuaWeiPhone() {
        super();
    }

    public HuaWeiPhone(double length, double width, double thick, String color) {
        super(length, width, thick, color);
    }

    @Override
    public void call(String name) {
        System.out.println("使用HuaWei手机" + this.toString() + "打电话给" + name);
    }

    @Override
    public void sendMessage(String name, String message) {
        System.out.println("使用HuaWei手机" + this.toString() + "发短信给" + name + ",内容为：" + message);
    }
}
