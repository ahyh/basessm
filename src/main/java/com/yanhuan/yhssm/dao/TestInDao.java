package com.yanhuan.yhssm.dao;

import com.yanhuan.yhssm.domain.pojo.TestIn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao:salary表
 * Created by yanhuan1 on 2018/1/16.
 */
public interface TestInDao {

    Integer insert(TestIn salary);

    /**
     * 批量插入方法
     */
    Integer batchInsert(@Param("list") List<TestIn> testInList);


}
