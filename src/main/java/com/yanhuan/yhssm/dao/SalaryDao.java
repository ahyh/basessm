package com.yanhuan.yhssm.dao;

import com.yanhuan.yhssm.domain.Salary;
import com.yanhuan.yhssm.domain.SalaryCondition;

import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public interface SalaryDao {

    Integer insert(Salary salary);

    Integer update(Salary salary);

    Integer delete(Long id);

    List<Salary> findSalaryList(SalaryCondition condition);

    List<Salary> findSalaryPage(SalaryCondition condition);
}
