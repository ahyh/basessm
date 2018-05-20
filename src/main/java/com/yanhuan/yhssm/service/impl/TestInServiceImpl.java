package com.yanhuan.yhssm.service.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.TestInDao;
import com.yanhuan.yhssm.domain.pojo.TestIn;
import com.yanhuan.yhssm.service.TestInService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
