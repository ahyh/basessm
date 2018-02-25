package designPattern.test.strategy.pojo;

import com.google.common.base.Preconditions;
import designPattern.test.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 体重推荐策略
 */
public class WeightStrategy implements Strategy {

    /**
     * 根据不同的体重推荐不同的商品
     */
    @Override
    public List<String> recommendGoodsList(Person person) {
        List<String> goodsList = new ArrayList<>();
        Preconditions.checkNotNull(person);
        Double weight = person.getWeight();
        if (weight > 40.0 && weight <= 50.0) {
            goodsList.add("金华火腿");
        } else if (weight > 50.0 && weight <= 60.0) {
            goodsList.add("蛋白粉");
        } else if (weight > 60.0 && weight <= 70.0) {
            goodsList.add("卤肉火烧");
        } else if (weight > 70.0 && weight <= 80.0) {
            goodsList.add("红富士大苹果");
        } else if (weight > 80.0 && weight <= 90.0) {
            goodsList.add("跑步机");
        } else {
            goodsList.add("特大号椅子");
        }
        return goodsList;
    }

}
