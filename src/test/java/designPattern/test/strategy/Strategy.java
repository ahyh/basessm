package designPattern.test.strategy;

import designPattern.test.strategy.pojo.Person;

import java.util.List;

/**
 * 策略接口
 */
public interface Strategy {

    /**
     * 根据Person的具体信息推荐商品集合
     */
    List<String> recommendGoodsList(Person person);

}
