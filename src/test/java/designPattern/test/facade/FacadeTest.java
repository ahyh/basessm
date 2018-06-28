package designPattern.test.facade;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 外观模式测试
 */
public class FacadeTest {

    private FacadeAPI facadeAPI;

    @Test
    public void testFacadeApi() {
        this.facadeAPI = new FacadeAPI(new ServiceA(), new ServiceB(), new ServiceC());
        Param param = new Param();
        param.setInvoker("user");
        param.setToken("123456");
        Map<String, Object> map = new HashMap<>();
        map.put("fieldA", "valueA");
        map.put("fieldB", "valueB");
        map.put("fieldC", "valueC");
        param.setParamMap(map);
        Result handle = facadeAPI.handle(param);
        System.out.println(handle);
    }
}
