package com.yanhuan.yhssm.service;

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

}
