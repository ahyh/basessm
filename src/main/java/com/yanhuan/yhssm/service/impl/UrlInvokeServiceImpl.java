package com.yanhuan.yhssm.service.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.UrlInvokeDao;
import com.yanhuan.yhssm.domain.condition.UrlInvokeCondition;
import com.yanhuan.yhssm.domain.pojo.UrlInvoke;
import com.yanhuan.yhssm.service.UrlInvokeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * UrlInvoke服务实现类
 *
 * @author yanhuan1
 */
@Service
public class UrlInvokeServiceImpl implements UrlInvokeService {

    @Resource
    private UrlInvokeDao urlInvokeDao;


    @Override
    public Integer insert(UrlInvoke urlInvoke) {
        Preconditions.checkNotNull(urlInvoke);
        return urlInvokeDao.insert(urlInvoke);
    }

    @Override
    public UrlInvoke getUrlInvokeByCondition(UrlInvokeCondition condition) {
        Preconditions.checkNotNull(condition);
        return urlInvokeDao.getUrlInvokeByCondition(condition);
    }

    @Override
    public List<UrlInvoke> findUrlInvokeList(UrlInvokeCondition condition) {
        Preconditions.checkNotNull(condition);
        return urlInvokeDao.findUrlInvokeList(condition);
    }
}
