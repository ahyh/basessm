package com.yanhuan.yhssm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yanhuan.yhssm.domain.Salary;
import com.yanhuan.yhssm.domain.SalaryCondition;
import com.yanhuan.yhssm.domain.SalaryPageCondition;

import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public interface SalaryService {

    Integer insert(Salary salary);

    Integer update(Salary salary);

    Integer delete(Long id);

    Salary getSalaryByCondition(SalaryCondition condition);

    List<Salary> findSalaryList(SalaryCondition condition);

    PageInfo<Salary> selectSalaryPage(SalaryPageCondition condition);

}
