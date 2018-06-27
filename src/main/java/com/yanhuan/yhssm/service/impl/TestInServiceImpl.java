package com.yanhuan.yhssm.service.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.TestInDao;
import com.yanhuan.yhssm.domain.condition.TestInCondition;
import com.yanhuan.yhssm.domain.pojo.TestIn;
import com.yanhuan.yhssm.service.TestInService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class TestInServiceImpl implements TestInService {

    @Resource
    private TestInDao testInDao;

    @Override
    public Integer insert(TestIn testIn) {
        Preconditions.checkNotNull(testIn);
        return testInDao.insert(testIn);
    }

    @Override
    public Integer batchInsert(List<TestIn> testInList) {
        if (CollectionUtils.isNotEmpty(testInList)) {
            return testInDao.batchInsert(testInList);
        }
        return 0;
    }

    /**
     * 更新并插入新的记录，测试更新是否会占用索引导致死锁问题
     *
     * @param testIn
     * @return
     */
    @Override
    @Transactional
    public Boolean updateAndInsert(TestIn testIn) {
        Preconditions.checkArgument(testIn != null, "testIn cannot null！");
        Integer update = testInDao.update(testIn);
        Preconditions.checkArgument(update == 1, "更新失败!");
        testIn.setMainNo("new" + testIn.getMainNo());
        testIn.setSlaveNo("new" + testIn.getSlaveNo());
        Integer insert = testInDao.insert(testIn);
        Preconditions.checkArgument(insert == 1, "插入失败!");
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteAndInsert(TestIn testIn) {
        Preconditions.checkArgument(testIn != null, "testIn cannot null！");
        Integer update = testInDao.delete(testIn);
        Preconditions.checkArgument(update == 1, "删除失败!");
        testIn.setMainNo("new" + testIn.getMainNo());
        testIn.setSlaveNo("new" + testIn.getSlaveNo());
        Integer insert = testInDao.insert(testIn);
        Preconditions.checkArgument(insert == 1, "插入失败!");
        return true;
    }

    @Override
    @Transactional
    public Boolean updateAndInsertBatch(TestInCondition testInCondition) {
        List<TestIn> testInList = testInDao.findTestInListByCondition(testInCondition);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(testInList), "testInList cannot empty!");
        for (TestIn testIn : testInList) {
            executorService.submit(() -> {
                testInDao.deleteByMainNoAndSalveNo(testIn);
                testIn.setCreateUser("yhyh");
                testInDao.insert(testIn);
                System.out.println("===========================");
            });
        }
        boolean shutdown = executorService.isShutdown();
        System.out.println(shutdown);
        if(shutdown){
            executorService.shutdown();
        }
        return true;
    }


}
