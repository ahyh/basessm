package com.yanhuan.yhssm.service;

import com.github.pagehelper.PageInfo;
import com.yanhuan.yhssm.domain.pojo.Salary;
import com.yanhuan.yhssm.domain.condition.SalaryCondition;

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

    PageInfo<Salary> selectSalaryPage(SalaryCondition condition);

    /**
     * 批量插入方法
     */
    Integer batchInsert(List<Salary> salaryList);

    /**
     * 批量删除方法
     */
    Integer batchDelete(List<Long> idList);

    /**
     * 批量插入或更新方法（不存在就插入，否则更新）
     */
    Integer batchInsertOrUpdate(List<Salary> salaryList);

    /**
     * 物理删除
     */
    Integer deletePhysics(Long id);

    List<Salary> findByDateSub(Integer days);

    List<Salary> findSalaryListBySalaryList(List<Salary> salaryList);
}
