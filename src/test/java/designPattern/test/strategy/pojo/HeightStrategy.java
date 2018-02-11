package designPattern.test.strategy.pojo;

import com.google.common.base.Preconditions;
import designPattern.test.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 身高推荐策略
 */
public class HeightStrategy implements Strategy {

    /**
     * 根据身高推荐不同的商品
     */
    @Override
    public List<String> recommendGoodsList(Person person) {
        List<String> goodsList = new ArrayList<>();
        Preconditions.checkNotNull(person);
        Double height = person.getHeight();
        if (height > 150.0 && height <= 160.0) {
            goodsList.add("内增高");
        } else if (height > 160.0 && height <= 170.0) {
            goodsList.add("厚板鞋");
        } else if (height > 170.0 && height <= 180.0) {
            goodsList.add("大风衣");
        } else {
            goodsList.add("Air Jordan");
        }
        return goodsList;
    }

}
