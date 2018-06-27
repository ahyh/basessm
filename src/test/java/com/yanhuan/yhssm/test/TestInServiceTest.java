package com.yanhuan.yhssm.test;

import com.yanhuan.yhssm.domain.condition.TestInCondition;
import com.yanhuan.yhssm.domain.pojo.TestIn;
import com.yanhuan.yhssm.service.TestInService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import utils.test.GenerateUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public class TestInServiceTest extends BaseTest {

    private static Logger logger = LogManager.getLogger(TestInServiceTest.class);

    @Resource
    protected TestInService testInService;

    @Test
    public void testInsertBatch() {
        List<TestIn> testInList = new ArrayList<>(100);
        TestIn testIn;
        Date date = new Date();
        for (int k = 0; k < 100; k++) {
            for (int i = 10; i < 20; i++) {
                for (int j = 10; j < 20; j++) {
                    testIn = new TestIn();
                    testIn.setMainNo("ZZ9001-" + k + "-" + i + "-" + j);
                    testIn.setSlaveNo("ZZ0001-" + k + "-" + i + "-" + j);
                    testIn.setName(GenerateUtils.getNameRandom());
                    testIn.setAge(k + i + j);
                    testIn.setCreateTime(date);
                    testIn.setUpdateTime(date);
                    testIn.setCreateUser("yh");
                    testIn.setUpdateUser("yh");
                    testInList.add(testIn);
                }
            }
            testInService.batchInsert(testInList);
        }
    }

    @Test
    public void testUpdateAndInsert(){
        TestIn testIn = new TestIn();
        testIn.setId(6l);
        testIn.setMainNo("PP1001-0-0-5");
        testIn.setSlaveNo("QQQ1001-0-0-5");
        testIn.setName("王慧");
        testIn.setAge(5);
        testIn.setUpdateUser("yhyhyh");
        Boolean flag = testInService.updateAndInsert(testIn);
        System.out.println(flag);
    }

    @Test
    public void testDeleteAndInsert(){
        TestIn testIn = new TestIn();
        testIn.setId(6l);
        testIn.setMainNo("YYY1001-0-0-5");
        testIn.setSlaveNo("HHH1001-0-0-5");
        testIn.setName("王慧");
        testIn.setAge(26);
        testIn.setUpdateUser("yhyhyh");
        Boolean flag = testInService.deleteAndInsert(testIn);
        System.out.println(flag);
    }

    @Test
    public void testUpdateAndInsertBatch(){
        TestInCondition condition = new TestInCondition();
        condition.setAge(5);
        Boolean aBoolean = testInService.updateAndInsertBatch(condition);
    }





}
