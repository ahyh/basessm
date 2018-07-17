package com.yanhuan.yhssm.service;

import com.yanhuan.yhssm.domain.condition.UrlInvokeCondition;
import com.yanhuan.yhssm.domain.pojo.UrlInvoke;

import java.util.List;

/**
 * urlInvoke服务
 */
public interface UrlInvokeService {

    Integer insert(UrlInvoke salary);

    UrlInvoke getUrlInvokeByCondition(UrlInvokeCondition condition);

    List<UrlInvoke> findUrlInvokeList(UrlInvokeCondition condition);
}
