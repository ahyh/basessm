package designPattern.test.strategy.pojo;

import com.google.common.base.Preconditions;
import designPattern.test.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据年龄推荐
 */
public class AgeStrategy implements Strategy {

    /**
     * 根据不同的年龄推荐不同的商品
     */
    @Override
    public List<String> recommendGoodsList(Person person) {
        Preconditions.checkNotNull(person);
        List<String> goodsList = new ArrayList<>();
        Integer age = person.getAge();
        if (age <= 10) {
            goodsList.add("棒棒糖");
        } else if (age > 10 && age <= 20) {
            goodsList.add("四大名著");
        } else if (age > 20 && age <= 30) {
            goodsList.add("NorthFace");
        } else if (age > 30 && age <= 40) {
            goodsList.add("章光101");
        } else if (age > 40 && age <= 50) {
            goodsList.add("老人按摩机");
        } else {
            goodsList.add("老人机，字超大的");
        }
        return goodsList;
    }

}
