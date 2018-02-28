package designPattern.test.strategy.pojo;

import com.google.common.base.Preconditions;
import designPattern.test.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 地址推荐策略
 */
public class AddressStrategy implements Strategy {

    /**
     * 根据不同的地址推荐不同商品
     */
    @Override
    public List<String> recommendGoodsList(Person person) {
        List<String> goodsList = new ArrayList<>();
        Preconditions.checkNotNull(person);
        String address = person.getAddress();
        if(address.startsWith("北京")){
            goodsList.add("大前门");
        } else if(address.startsWith("湖北")){
            goodsList.add("黄鹤楼");
        } else if(address.startsWith("河南")){
            goodsList.add("红旗渠");
        } else if(address.startsWith("云南")){
            goodsList.add("红塔山");
        } else if(address.startsWith("安徽")){
            goodsList.add("一品黄山");
        } else {
            goodsList.add("中华");
        }
        return goodsList;
    }

}
