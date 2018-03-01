package designPattern.test.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理类
 */
public class Manager {

    private Map<String, Product> productMap = new HashMap();

    //注册产品
    public void register(String name, Product product) {
        productMap.put(name, product);
    }

    //克隆出产品并返回
    public Product create(String name) {
        Product p = productMap.get(name);
        return p.createClone();
    }
}
