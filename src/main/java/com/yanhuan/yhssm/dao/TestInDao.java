package com.yanhuan.yhssm.dao;

import com.yanhuan.yhssm.domain.condition.TestInCondition;
import com.yanhuan.yhssm.domain.pojo.TestIn;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Dao:test_in表
 *
 * @author yanhuan1
 */
public interface TestInDao {

    Integer insert(TestIn salary);

    /**
     * 批量插入方法
     */
    Integer batchInsert(@Param("list") List<TestIn> testInList);

    /**
     * 更新方法
     *
     * @param testIn 需要更新的记录
     * @return
     */
    Integer update(TestIn testIn);

    /**
     * 删除方法
     * @param testIn
     * @return
     */
    Integer delete(TestIn testIn);

    /**
     * 更具id获取
     * @param id
     * @return
     */
    TestIn get(Long id);

    /**
     * 根据查询条件获取
     * @param testInCondition
     * @return
     */
    List<TestIn> findTestInListByCondition(TestInCondition testInCondition);

    /**
     * 根据mainNo和slaveNo进行物理删除
     * @param testIn
     * @return
     */
    Integer deleteByMainNoAndSalveNo(TestIn testIn);

}
