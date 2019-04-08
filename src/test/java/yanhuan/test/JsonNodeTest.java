package yanhuan.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yanhuan.yhssm.domain.pojo.Salary;
import org.junit.Test;

public class JsonNodeTest {

    @Test
    public void testJsonNode() throws Exception {
        Salary salary = new Salary();
        salary.setName("yanhuan");
        String s = JSON.toJSONString(salary);
        JSONObject object = (JSONObject) JSONObject.parse(s);
        object.put("age",16);
        System.out.println(object);
    }
}
