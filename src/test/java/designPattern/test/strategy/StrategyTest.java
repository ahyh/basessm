package designPattern.test.strategy;

import designPattern.test.strategy.pojo.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略模式测试
 */
public class StrategyTest {

    /**
     * 新建不同的策略，实际项目中一般采用Spring注入的方式
     * 将所有的策略都放在容器中，实际使用时注入不同的策略即可
     */
    private Strategy ageStrategy = new AgeStrategy();
    private Strategy genderStrategy = new GenderStrategy();
    private Strategy heightStrategy = new HeightStrategy();
    private Strategy weightStrategy = new WeightStrategy();
    private Strategy addressStrategy = new AddressStrategy();

    /**
     * 测试数据
     */
    private Person person = new Person("yudaijing", 27, (byte) 0, 56.0, 168.0, "安徽合肥");

    /**
     * 测试策略模式
     */
    @Test
    public void testStrategy() {
        List<String> goodsList = new ArrayList<>();
        List<String> ageRecommendGoodsList = ageStrategy.recommendGoodsList(person);
        List<String> genderRecommendGoodsList = genderStrategy.recommendGoodsList(person);
        List<String> heightRecommendGoodsList = heightStrategy.recommendGoodsList(person);
        List<String> weightRecommendGoodsList = weightStrategy.recommendGoodsList(person);
        List<String> addressRecommendGoodsList = addressStrategy.recommendGoodsList(person);
        goodsList.addAll(ageRecommendGoodsList);
        goodsList.addAll(genderRecommendGoodsList);
        goodsList.addAll(heightRecommendGoodsList);
        goodsList.addAll(weightRecommendGoodsList);
        goodsList.addAll(addressRecommendGoodsList);
        goodsList.stream().forEach(System.out::println);
    }


}
