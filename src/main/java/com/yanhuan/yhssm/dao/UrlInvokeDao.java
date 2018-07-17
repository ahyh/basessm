package com.yanhuan.yhssm.dao;

import com.yanhuan.yhssm.domain.condition.UrlInvokeCondition;
import com.yanhuan.yhssm.domain.pojo.UrlInvoke;

import java.util.List;

/**
 * url_invoke表Dao
 */
public interface UrlInvokeDao {

    Integer insert(UrlInvoke salary);

    UrlInvoke getUrlInvokeByCondition(UrlInvokeCondition condition);

    List<UrlInvoke> findUrlInvokeList(UrlInvokeCondition condition);
}
