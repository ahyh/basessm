package com.yanhuan.yhssm.service;

import com.yanhuan.yhssm.domain.condition.TestInCondition;
import com.yanhuan.yhssm.domain.pojo.TestIn;

import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public interface TestInService {

    Integer insert(TestIn salary);

    /**
     * 批量插入方法
     */
    Integer batchInsert(List<TestIn> testInList);

    /**
     * 更新并插入新的记录，测试更新的时候是否占用索引导致死锁问题
     *
     * @param testIn
     * @return
     */
    Boolean updateAndInsert(TestIn testIn);

    /**
     * 更新并插入新的记录，测试更新的时候是否占用索引导致死锁问题
     *
     * @param testIn
     * @return
     */
    Boolean deleteAndInsert(TestIn testIn);

    /**
     * 更新并插入新的记录，测试更新的时候是否占用索引导致死锁问题
     *
     * @param testInCondition
     * @return
     */
    Boolean updateAndInsertBatch(TestInCondition testInCondition);

}
