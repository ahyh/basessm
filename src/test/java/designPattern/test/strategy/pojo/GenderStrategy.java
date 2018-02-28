package designPattern.test.strategy.pojo;

import com.google.common.base.Preconditions;
import designPattern.test.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据性别推荐
 */
public class GenderStrategy implements Strategy {

    /**
     * 具体的推荐逻辑，根据性别推荐不同的商品
     */
    @Override
    public List<String> recommendGoodsList(Person person) {
        List<String> goodsList = new ArrayList<>();
        Preconditions.checkNotNull(person);
        //男孩都有吉他，女孩都有舞鞋
        if (person.getGender() == 1) {
            goodsList.add("吉他");
        } else {
            goodsList.add("舞鞋");
        }
        return goodsList;
    }

}
