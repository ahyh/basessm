package designPattern.test.builder.vo;

/**
 * 具体的产品：长征5号
 */
public class ChangZheng5 extends Rocket {

    @Override
    public void launch() {
       System.out.println("5 4 3 2 1 长征5号发射成功！鼓掌....");
    }

}
